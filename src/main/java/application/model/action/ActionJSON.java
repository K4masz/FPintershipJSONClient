package application.model.action;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Command",
        "Login",
        "Token",
        "Parameter",
        "Value"
})
public class ActionJSON {

    @JsonProperty("Command")
    private String command;
    @JsonProperty("Login")
    private String login;
    @JsonProperty("Token")
    private String token;
    @JsonProperty("Parameter")
    private Object parameter;
    @JsonProperty("Value")
    private Object value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Command")
    public String getCommand() {
        return command;
    }

    @JsonProperty("Command")
    public void setCommand(String command) {
        this.command = command;
    }

    public ActionJSON withCommand(String command) {
        this.command = command;
        return this;
    }

    @JsonProperty("Login")
    public String getLogin() {
        return login;
    }

    @JsonProperty("Login")
    public void setLogin(String login) {
        this.login = login;
    }

    public ActionJSON withLogin(String login) {
        this.login = login;
        return this;
    }

    @JsonProperty("Token")
    public String getToken() {
        return token;
    }

    @JsonProperty("Token")
    public void setToken(String token) {
        this.token = token;
    }

    public ActionJSON withToken(String token) {
        this.token = token;
        return this;
    }

    @JsonProperty("Parameter")
    public Object getParameter() {
        return parameter;
    }

    @JsonProperty("Parameter")
    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }

    public ActionJSON withParameter(Object parameter) {
        this.parameter = parameter;
        return this;
    }

    @JsonProperty("Value")
    public Object getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(Object value) {
        this.value = value;
    }

    public ActionJSON withValue(Object value) {
        this.value = value;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public ActionJSON withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}