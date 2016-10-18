package com.charniauski.training.horsesrace.datamodelmax;

/**
 * Created by ivc4 on 17.10.2016.
 */
public class HorseDescription extends AbstractModel{
    private String description;
    private Integer weight;
    private Boolean gender;

//    private Horse horse;

    public HorseDescription() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}
