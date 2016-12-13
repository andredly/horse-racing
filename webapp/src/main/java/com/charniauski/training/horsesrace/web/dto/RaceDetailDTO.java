package com.charniauski.training.horsesrace.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RaceDetailDTO {

    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull
    private Long raceCardId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull
    private Long horseId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull
    private Long commandId;

    @NotNull
    @Min(1)
    private Integer numberStartBox;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer horseResult;

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

}
