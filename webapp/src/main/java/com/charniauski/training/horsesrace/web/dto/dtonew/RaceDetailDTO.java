package com.charniauski.training.horsesrace.web.dto.dtonew;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

public class RaceDetailDTO {

    private Long id;

    private RaceCardDTO raceCardDTO;

  private HorseDTO horseDTO;

    private CommandDTO commandDTO;

    private List<EventDTO> eventDTOList;

    @NotNull
    @Min(1)
    private Integer numberStartBox;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer horseResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RaceCardDTO getRaceCardDTO() {
        return raceCardDTO;
    }

    public void setRaceCardDTO(RaceCardDTO raceCardDTO) {
        this.raceCardDTO = raceCardDTO;
    }

    public HorseDTO getHorseDTO() {
        return horseDTO;
    }

    public void setHorseDTO(HorseDTO horseDTO) {
        this.horseDTO = horseDTO;
    }

    public CommandDTO getCommandDTO() {
        return commandDTO;
    }

    public void setCommandDTO(CommandDTO commandDTO) {
        this.commandDTO = commandDTO;
    }

    public List<EventDTO> getEventDTOList() {
        return eventDTOList;
    }

    public void setEventDTOList(List<EventDTO> eventDTOList) {
        this.eventDTOList = eventDTOList;
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
        return "RaceDetailDTO{" +
                "id=" + id +
                ", raceCardDTO=" + raceCardDTO +
                ", horseDTO=" + horseDTO +
                ", commandDTO=" + commandDTO +
                ", eventDTOList=" + eventDTOList +
                ", numberStartBox=" + numberStartBox +
                ", horseResult=" + horseResult +
                '}';
    }
}
