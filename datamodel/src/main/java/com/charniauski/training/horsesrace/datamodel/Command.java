package com.charniauski.training.horsesrace.datamodel;

import com.charniauski.training.horsesrace.datamodel.annotation.Column;
import com.charniauski.training.horsesrace.datamodel.annotation.Entity;

@Entity(tableName = "command",autoincrementColumn = "id")
public class Command extends AbstractModel {

    @Column(columnName = "name_command")
    private String nameCommand;

    @Column(columnName = "trainer")
    private String trainer;

    @Column(columnName = "jockey")
    private String jockey;

    @Column(columnName = "url_image_color")
    private String urlImageColor;

//    private Horse horse;

    public Command() {
    }

    public String getNameCommand() {
        return nameCommand;
    }

    public void setNameCommand(String nameCommand) {
        this.nameCommand = nameCommand;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getJockey() {
        return jockey;
    }

    public void setJockey(String jockey) {
        this.jockey = jockey;
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
                "id=" + getId() +
                "nameCommand='" + nameCommand + '\'' +
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
        if (getId() != null ? !getId().equals(command.getId()) : command.getId() != null) return false;
        if (nameCommand != null ? !nameCommand.equals(command.nameCommand) : command.nameCommand != null) return false;
        if (trainer != null ? !trainer.equals(command.trainer) : command.trainer != null) return false;
        if (jockey != null ? !jockey.equals(command.jockey) : command.jockey != null) return false;
        return urlImageColor != null ? urlImageColor.equals(command.urlImageColor) : command.urlImageColor == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (nameCommand != null ? nameCommand.hashCode() : 0);
        result = 31 * result + (trainer != null ? trainer.hashCode() : 0);
        result = 31 * result + (jockey != null ? jockey.hashCode() : 0);
        result = 31 * result + (urlImageColor != null ? urlImageColor.hashCode() : 0);
        return result;
    }
}
