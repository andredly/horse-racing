package com.charniauski.training.horsesrace.web.dto;

import org.hibernate.validator.constraints.NotBlank;

public class CommandDTO {

    private Long id;

    @NotBlank
    private String trainer;

    @NotBlank
    private String jockey;

    @NotBlank
    private String urlImageColor;

//    private Horse horse;

    public CommandDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", trainer='" + trainer + '\'' +
                ", jockey='" + jockey + '\'' +
                ", urlImageColor='" + urlImageColor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommandDTO that = (CommandDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (trainer != null ? !trainer.equals(that.trainer) : that.trainer != null) return false;
        if (jockey != null ? !jockey.equals(that.jockey) : that.jockey != null) return false;
        return urlImageColor != null ? urlImageColor.equals(that.urlImageColor) : that.urlImageColor == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (trainer != null ? trainer.hashCode() : 0);
        result = 31 * result + (jockey != null ? jockey.hashCode() : 0);
        result = 31 * result + (urlImageColor != null ? urlImageColor.hashCode() : 0);
        return result;
    }
}
