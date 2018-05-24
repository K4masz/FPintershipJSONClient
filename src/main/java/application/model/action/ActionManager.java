package application.model.action;

import application.model.enums.EActionType;
import application.model.enums.EParameterB;
import application.model.generated.Parameter;
import application.model.generated.Situation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;

import static application.utils.Config.*;

public class ActionManager {

    private static ActionManager ourInstance;
    private boolean simulationFlag;
    private OkHttpClient client;
    private ObjectMapper mapper;
    private MediaType mediaType;

    private ActionManager() {
        this.client = new OkHttpClient();
        this.mediaType = MediaType.parse("application/json");
        this.simulationFlag = true;
        this.mapper = new ObjectMapper();
    }

    public static ActionManager getInstance() {
        if (ourInstance == null)
            ourInstance = new ActionManager();
        return ourInstance;
    }

    public Response executeAction(Action action) throws IOException {
        return client.newCall(buildRequest(action)).execute();
    }

    private Request buildRequest(Action action) {
        String url = simulationFlag ? URL_SIMULATION_EXECUTE : URL_CHAARR_EXECUTE;

        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(mediaType, buildActionJSON(action)))
                .addHeader("content-type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();

        return request;
    }

    private String buildActionJSON(Action action) {
        try {

            ActionJSON json = new ActionJSON()
                    .withCommand(action.getActionType().toString())
                    .withLogin(LOGIN)
                    .withToken(TOKEN);

            if (!action.getActionType().equals(EActionType.RESTART))
                json.withParameter(action.getParametersList().get(0).getValue().toString());

            if (!action.getParametersList().isEmpty()) {

                if (action.getParametersList().get(0).getValue().equals(EParameterB.SUPPLIES) || action.getActionType().equals(EActionType.ORDER))
                    json.withValue(action.getParametersList().get(1).getValue());

                if (action.getActionType().equals(EActionType.RESTARTSIMULATION) && action.getParametersList().get(0).getValue() instanceof Parameter)
                    json.withParameter(action.getParametersList().get(0).getValue());
            }

            return mapper.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setSimulationFlag(boolean simulationFlag) {
        this.simulationFlag = simulationFlag;
    }

    public Situation getCurrentSituation() {
        try {
            String url = simulationFlag ? URL_SIMULATION_SITUATION : URL_CHAARR_SITUATION;

            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();

            String json = client
                    .newCall(request)
                    .execute()
                    .body()
                    .string();

            return mapper.readValue(json, Situation.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}


