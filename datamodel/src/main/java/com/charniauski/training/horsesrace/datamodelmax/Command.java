package com.charniauski.training.horsesrace.datamodelmax;

public class Command extends AbstractModel{

    private String urlImageColor;

//    private Horse horse;
//    private Jockey jockey;
//    private Trainer trainer;

    public Command() {
    }

    public String getUrlImageColor() {
        return urlImageColor;
    }

    public void setUrlImageColor(String urlImageColor) {
        this.urlImageColor = urlImageColor;
    }
}
