package application.model.generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "survivorsScore",
        "scienceScore",
        "crewMalus",
        "knowledgeScore",
        "eventScore",
        "totalScore"
})
public class Scores {

    @JsonProperty("survivorsScore")
    private Integer survivorsScore;
    @JsonProperty("scienceScore")
    private Integer scienceScore;
    @JsonProperty("crewMalus")
    private Integer crewMalus;
    @JsonProperty("knowledgeScore")
    private Integer knowledgeScore;
    @JsonProperty("eventScore")
    private Integer eventScore;
    @JsonProperty("totalScore")
    private Integer totalScore;

    @JsonProperty("survivorsScore")
    public Integer getSurvivorsScore() {
        return survivorsScore;
    }

    @JsonProperty("survivorsScore")
    public void setSurvivorsScore(Integer survivorsScore) {
        this.survivorsScore = survivorsScore;
    }

    public Scores withSurvivorsScore(Integer survivorsScore) {
        this.survivorsScore = survivorsScore;
        return this;
    }

    @JsonProperty("scienceScore")
    public Integer getScienceScore() {
        return scienceScore;
    }

    @JsonProperty("scienceScore")
    public void setScienceScore(Integer scienceScore) {
        this.scienceScore = scienceScore;
    }

    public Scores withScienceScore(Integer scienceScore) {
        this.scienceScore = scienceScore;
        return this;
    }

    @JsonProperty("crewMalus")
    public Integer getCrewMalus() {
        return crewMalus;
    }

    @JsonProperty("crewMalus")
    public void setCrewMalus(Integer crewMalus) {
        this.crewMalus = crewMalus;
    }

    public Scores withCrewMalus(Integer crewMalus) {
        this.crewMalus = crewMalus;
        return this;
    }

    @JsonProperty("knowledgeScore")
    public Integer getKnowledgeScore() {
        return knowledgeScore;
    }

    @JsonProperty("knowledgeScore")
    public void setKnowledgeScore(Integer knowledgeScore) {
        this.knowledgeScore = knowledgeScore;
    }

    public Scores withKnowledgeScore(Integer knowledgeScore) {
        this.knowledgeScore = knowledgeScore;
        return this;
    }

    @JsonProperty("eventScore")
    public Integer getEventScore() {
        return eventScore;
    }

    @JsonProperty("eventScore")
    public void setEventScore(Integer eventScore) {
        this.eventScore = eventScore;
    }

    public Scores withEventScore(Integer eventScore) {
        this.eventScore = eventScore;
        return this;
    }

    @JsonProperty("totalScore")
    public Integer getTotalScore() {
        return totalScore;
    }

    @JsonProperty("totalScore")
    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Scores withTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Scores: " + "\n");
        sb.append("\tSurvivorsScore: " + this.getSurvivorsScore() + "\n");
        sb.append("\tScienceScore: " + this.getScienceScore() + "\n");
        sb.append("\tCrewMalus: " + this.getCrewMalus() + "\n");
        sb.append("\tKnowledgeScore: " + this.getKnowledgeScore() + "\n");
        sb.append("\tEventScore: " + this.getEventScore() + "\n");
        sb.append("\tTotalScore: " + this.getTotalScore() + "\n");

        return sb.toString();
    }
}