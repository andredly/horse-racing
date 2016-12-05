package com.charniauski.training.horsesrace.web.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RaceDetailDTO {

    private Long id;

    @NotNull
    private Long raceCardId;

    @NotNull
    private Long horseId;

    @NotNull
    private Long commandId;

    @NotNull
    @Min(1)
    private Integer numberStartBox;

    private Integer horseResult;

//    private List<Horse> horses;
//    private RaceCard raceCard;

    public RaceDetailDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRaceCardId() {
        return raceCardId;
    }

    public void setRaceCardId(Long raceCardId) {
        this.raceCardId = raceCardId;
    }

    public Long getHorseId() {
        return horseId;
    }

    public void setHorseId(Long horseId) {
        this.horseId = horseId;
    }

    public Long getCommandId() {
        return commandId;
    }

    public void setCommandId(Long commandId) {
        this.commandId = commandId;
    }

    public Integer getNumberStartBox() {
        return numberStartBox;
    }

    public void setNumberStartBox(Integer numberStartBox) {
        this.numberStartBox = numberStartBox;
    }

    public Integer getHorseResult() {
        return horseResult;
    }

    public void setHorseResult(Integer horseResult) {
        this.horseResult = horseResult;
    }


    @Override
    public String toString() {
        return "RaceDetail{" +
                "id=" + id +
                ", raceCardId=" + raceCardId +
                ", horseId=" + horseId +
                ", commandId=" + commandId +
                ", numberStartBox=" + numberStartBox +
                ", horseResult=" + horseResult +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceDetailDTO that = (RaceDetailDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (raceCardId != null ? !raceCardId.equals(that.raceCardId) : that.raceCardId != null) return false;
        if (horseId != null ? !horseId.equals(that.horseId) : that.horseId != null) return false;
        if (commandId != null ? !commandId.equals(that.commandId) : that.commandId != null) return false;
        if (numberStartBox != null ? !numberStartBox.equals(that.numberStartBox) : that.numberStartBox != null)
            return false;
        return horseResult != null ? horseResult.equals(that.horseResult) : that.horseResult == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (raceCardId != null ? raceCardId.hashCode() : 0);
        result = 31 * result + (horseId != null ? horseId.hashCode() : 0);
        result = 31 * result + (commandId != null ? commandId.hashCode() : 0);
        result = 31 * result + (numberStartBox != null ? numberStartBox.hashCode() : 0);
        result = 31 * result + (horseResult != null ? horseResult.hashCode() : 0);
        return result;
    }
}
