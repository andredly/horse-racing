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
                ", trainer='" + trainer + '\'' +
                ", jockey='" + jockey + '\'' +
                ", urlImageColor='" + urlImageColor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Command command = (Command) o;

        if (trainer != null ? !trainer.equals(command.trainer) : command.trainer != null) return false;
        if (jockey != null ? !jockey.equals(command.jockey) : command.jockey != null) return false;
        return urlImageColor != null ? urlImageColor.equals(command.urlImageColor) : command.urlImageColor == null;

    }

    @Override
    public int hashCode() {
        int result = trainer != null ? trainer.hashCode() : 0;
        result = 31 * result + (jockey != null ? jockey.hashCode() : 0);
        result = 31 * result + (urlImageColor != null ? urlImageColor.hashCode() : 0);
        return result;
    }
}
