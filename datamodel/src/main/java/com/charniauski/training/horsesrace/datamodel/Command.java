package com.charniauski.training.horsesrace.datamodel;

public class Command extends AbstractModel{
    private String jockey;
    private String trainer;
    private String urlImageColor;

//    private Horse horse;

    public Command() {
    }

    public String getJockey() {
        return jockey;
    }

    public void setJockey(String jockey) {
        this.jockey = jockey;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getUrlImageColor() {
        return urlImageColor;
    }

    public void setUrlImageColor(String urlImageColor) {
        this.urlImageColor = urlImageColor;
    }
}