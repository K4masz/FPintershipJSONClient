package application.model.generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "chaarrHatred",
        "knowledge",
        "crewDeaths",
        "survivorDeaths",
        "savedScience",
        "savedSurvivors",
        "południcaMatter",
        "południcaEnergy",
        "expeditionMatter",
        "expeditionEnergy"
})
public class Parameter {

    @JsonProperty("chaarrHatred")
    private Integer chaarrHatred;
    @JsonProperty("knowledge")
    private Integer knowledge;
    @JsonProperty("crewDeaths")
    private Integer crewDeaths;
    @JsonProperty("survivorDeaths")
    private Integer survivorDeaths;
    @JsonProperty("savedScience")
    private Integer savedScience;
    @JsonProperty("savedSurvivors")
    private Integer savedSurvivors;
    @JsonProperty("południcaMatter")
    private Integer poludnicaMatter;
    @JsonProperty("południcaEnergy")
    private Integer poludnicaEnergy;
    @JsonProperty("expeditionMatter")
    private Integer expeditionMatter;
    @JsonProperty("expeditionEnergy")
    private Integer expeditionEnergy;

    @JsonProperty("chaarrHatred")
    public Integer getChaarrHatred() {
        return chaarrHatred;
    }

    @JsonProperty("chaarrHatred")
    public void setChaarrHatred(Integer chaarrHatred) {
        this.chaarrHatred = chaarrHatred;
    }

    public Parameter withChaarrHatred(Integer chaarrHatred) {
        this.chaarrHatred = chaarrHatred;
        return this;
    }

    @JsonProperty("knowledge")
    public Integer getKnowledge() {
        return knowledge;
    }

    @JsonProperty("knowledge")
    public void setKnowledge(Integer knowledge) {
        this.knowledge = knowledge;
    }

    public Parameter withKnowledge(Integer knowledge) {
        this.knowledge = knowledge;
        return this;
    }

    @JsonProperty("crewDeaths")
    public Integer getCrewDeaths() {
        return crewDeaths;
    }

    @JsonProperty("crewDeaths")
    public void setCrewDeaths(Integer crewDeaths) {
        this.crewDeaths = crewDeaths;
    }

    public Parameter withCrewDeaths(Integer crewDeaths) {
        this.crewDeaths = crewDeaths;
        return this;
    }

    @JsonProperty("survivorDeaths")
    public Integer getSurvivorDeaths() {
        return survivorDeaths;
    }

    @JsonProperty("survivorDeaths")
    public void setSurvivorDeaths(Integer survivorDeaths) {
        this.survivorDeaths = survivorDeaths;
    }

    public Parameter withSurvivorDeaths(Integer survivorDeaths) {
        this.survivorDeaths = survivorDeaths;
        return this;
    }

    @JsonProperty("savedScience")
    public Integer getSavedScience() {
        return savedScience;
    }

    @JsonProperty("savedScience")
    public void setSavedScience(Integer savedScience) {
        this.savedScience = savedScience;
    }

    public Parameter withSavedScience(Integer savedScience) {
        this.savedScience = savedScience;
        return this;
    }

    @JsonProperty("savedSurvivors")
    public Integer getSavedSurvivors() {
        return savedSurvivors;
    }

    @JsonProperty("savedSurvivors")
    public void setSavedSurvivors(Integer savedSurvivors) {
        this.savedSurvivors = savedSurvivors;
    }

    public Parameter withSavedSurvivors(Integer savedSurvivors) {
        this.savedSurvivors = savedSurvivors;
        return this;
    }

    @JsonProperty("południcaMatter")
    public Integer getPoludnicaMatter() {
        return poludnicaMatter;
    }

    @JsonProperty("południcaMatter")
    public void setPoludnicaMatter(Integer poludnicaMatter) {
        this.poludnicaMatter = poludnicaMatter;
    }

    public Parameter withPoUdnicaMatter(Integer poUdnicaMatter) {
        this.poludnicaMatter = poUdnicaMatter;
        return this;
    }

    @JsonProperty("południcaEnergy")
    public Integer getPoludnicaEnergy() {
        return poludnicaEnergy;
    }

    @JsonProperty("południcaEnergy")
    public void setPoludnicaEnergy(Integer poludnicaEnergy) {
        this.poludnicaEnergy = poludnicaEnergy;
    }

    public Parameter withPoUdnicaEnergy(Integer poUdnicaEnergy) {
        this.poludnicaEnergy = poUdnicaEnergy;
        return this;
    }

    @JsonProperty("expeditionMatter")
    public Integer getExpeditionMatter() {
        return expeditionMatter;
    }

    @JsonProperty("expeditionMatter")
    public void setExpeditionMatter(Integer expeditionMatter) {
        this.expeditionMatter = expeditionMatter;
    }

    public Parameter withExpeditionMatter(Integer expeditionMatter) {
        this.expeditionMatter = expeditionMatter;
        return this;
    }

    @JsonProperty("expeditionEnergy")
    public Integer getExpeditionEnergy() {
        return expeditionEnergy;
    }

    @JsonProperty("expeditionEnergy")
    public void setExpeditionEnergy(Integer expeditionEnergy) {
        this.expeditionEnergy = expeditionEnergy;
    }

    public Parameter withExpeditionEnergy(Integer expeditionEnergy) {
        this.expeditionEnergy = expeditionEnergy;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Parameters: " + "\n");
        sb.append("\tChaarrHatred: " + this.getChaarrHatred() + "\n");
        sb.append("\tKnowledge: " + this.getKnowledge() + "\n");
        sb.append("\tCrewDeaths: " + this.getCrewDeaths() + "\n");
        sb.append("\tSurvivorDeaths: " + this.getSurvivorDeaths() + "\n");
        sb.append("\tSavedScience: " + this.getSavedScience() + "\n");
        sb.append("\tSavedSurvivors: " + this.getSavedSurvivors() + "\n");
        sb.append("\tPołudnicaMatter: " + this.getPoludnicaMatter() + "\n");
        sb.append("\tPołudnicaEnergy: " + this.getPoludnicaEnergy() + "\n");
        sb.append("\tExpeditionMatter: " + this.getExpeditionMatter() + "\n");
        sb.append("\tExpeditionEnergy: " + this.getExpeditionEnergy() + "\n");

        return sb.toString();
    }
}