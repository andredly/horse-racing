package com.charniauski.training.horsesrace.datamodel;

@Entity(tableName = "command",autoincrementColumn = "id")
public class Command extends AbstractModel {

    @Column(columnName = "trainer")
    private String trainer;
    @Column(columnName = "jockey")
    private String jockey;
    @Column(columnName = "url_image_color")
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

    @Override
    public String toString() {
        return "Command{" +
                "id='" + getId() + '\'' +
                "trainer='" + trainer + '\'' +
                ", jockey='" + jockey + '\'' +
                ", urlImageColor='" + urlImageColor + '\'' +
                '}';
    }
}
