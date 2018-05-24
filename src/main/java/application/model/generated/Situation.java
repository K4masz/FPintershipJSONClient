package application.model.generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "turn",
        "location",
        "events",
        "lastTurnEvents",
        "equipments",
        "logBook",
        "scores",
        "parameters",
        "isTerminated"
})
public class Situation {

    @JsonProperty("turn")
    private Integer turn;
    @JsonProperty("location")
    private String location;
    @JsonProperty("events")
    private List<String> events = null;
    @JsonProperty("lastTurnEvents")
    private List<String> lastTurnEvents = null;
    @JsonProperty("equipments")
    private List<String> equipments = null;
    @JsonProperty("logBook")
    private List<String> logBook = null;
    @JsonProperty("scores")
    private Scores scores;
    @JsonProperty("parameters")
    private Parameter parameter;
    @JsonProperty("isTerminated")
    private Boolean isTerminated;

    @JsonProperty("turn")
    public Integer getTurn() {
        return turn;
    }

    @JsonProperty("turn")
    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public Situation withTurn(Integer turn) {
        this.turn = turn;
        return this;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    public Situation withLocation(String location) {
        this.location = location;
        return this;
    }

    @JsonProperty("events")
    public List<String> getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(List<String> events) {
        this.events = events;
    }

    public Situation withEvents(List<String> events) {
        this.events = events;
        return this;
    }

    @JsonProperty("lastTurnEvents")
    public List<String> getLastTurnEvents() {
        return lastTurnEvents;
    }

    @JsonProperty("lastTurnEvents")
    public void setLastTurnEvents(List<String> lastTurnEvents) {
        this.lastTurnEvents = lastTurnEvents;
    }

    public Situation withLastTurnEvents(List<String> lastTurnEvents) {
        this.lastTurnEvents = lastTurnEvents;
        return this;
    }

    @JsonProperty("equipments")
    public List<String> getEquipments() {
        return equipments;
    }

    @JsonProperty("equipments")
    public void setEquipments(List<String> equipments) {
        this.equipments = equipments;
    }

    public Situation withEquipments(List<String> equipments) {
        this.equipments = equipments;
        return this;
    }

    @JsonProperty("logBook")
    public List<String> getLogBook() {
        return logBook;
    }

    @JsonProperty("logBook")
    public void setLogBook(List<String> logBook) {
        this.logBook = logBook;
    }

    public Situation withLogBook(List<String> logBook) {
        this.logBook = logBook;
        return this;
    }

    @JsonProperty("scores")
    public Scores getScores() {
        return scores;
    }

    @JsonProperty("scores")
    public void setScores(Scores scores) {
        this.scores = scores;
    }

    public Situation withScores(Scores scoresJSON) {
        this.scores = scoresJSON;
        return this;
    }

    @JsonProperty("parameters")
    public Parameter getParameter() {
        return parameter;
    }

    @JsonProperty("parameters")
    public void setParameters(Parameter parameter) {
        this.parameter = parameter;
    }

    public Situation withParameters(Parameter parameter) {
        this.parameter = parameter;
        return this;
    }

    @JsonProperty("isTerminated")
    public Boolean getIsTerminated() {
        return isTerminated;
    }

    @JsonProperty("isTerminated")
    public void setIsTerminated(Boolean isTerminated) {
        this.isTerminated = isTerminated;
    }

    public Situation withIsTerminated(Boolean isTerminated) {
        this.isTerminated = isTerminated;
        return this;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Turn: " + this.getTurn().intValue() + "\n");
        sb.append("Location: " + this.getLocation() + "\n");
        sb.append("Last Turn Events: " + "\n");
        for (String event : this.getLastTurnEvents())
            sb.append("\t" + event + "\n");
        sb.append("Equipments: " + "\n");
        for (String equipment : this.getEquipments())
            sb.append("\t" + equipment + "\n");
        sb.append("LogBook: " + "\n");
        for (String log : this.getLogBook())
            sb.append("\t" + log + "\n");
        sb.append(scores.toString());
        sb.append(parameter.toString());
        sb.append("Terminated: " + this.getIsTerminated() + "\n");

        return sb.toString();
    }
}