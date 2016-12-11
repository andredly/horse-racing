package com.charniauski.training.horsesrace.web.dto.wrapper;

import com.charniauski.training.horsesrace.datamodel.*;
import com.charniauski.training.horsesrace.web.dto.*;

import java.util.List;

/**
 * Created by Andre on 05.11.2016.
 */
public class RaceDetailWrapperDTO {
    private RaceDetailDTO raceDetail;
    private RaceCardDTO raceCard;
    private HorseDTO horse;
    private CommandDTO command;
    private List<EventDTO> events;

    public RaceDetailDTO getRaceDetail() {
        return raceDetail;
    }

    public void setRaceDetail(RaceDetailDTO raceDetail) {
        this.raceDetail = raceDetail;
    }

    public RaceCardDTO getRaceCard() {
        return raceCard;
    }

    public void setRaceCard(RaceCardDTO raceCard) {
        this.raceCard = raceCard;
    }

    public HorseDTO getHorse() {
        return horse;
    }

    public void setHorse(HorseDTO horse) {
        this.horse = horse;
    }

    public CommandDTO getCommand() {
        return command;
    }

    public void setCommand(CommandDTO command) {
        this.command = command;
    }

    public List<EventDTO> getEvents() {
        return events;
    }

    public void setEvents(List<EventDTO> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "RaceDetailWrapperDTO{" +
                "raceDetail=" + raceDetail +
                ", raceCard=" + raceCard +
                ", horse=" + horse +
                ", command=" + command +
                ", events=" + events +
                '}';
    }
}
