package com.charniauski.training.horsesrace.web.dto.wrapper;

import com.charniauski.training.horsesrace.datamodel.*;
import com.charniauski.training.horsesrace.web.dto.*;

public class BetWrapperDTO {

    private BetDTO bet;
    private EventDTO event;
    private RacecourseDTO racecourse;
    private RaceCardDTO raceCard;
    private RaceDetailDTO raceDetail;
    private HorseDTO horse;

    public BetDTO getBet() {
        return bet;
    }

    public void setBet(BetDTO bet) {
        this.bet = bet;
    }

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public RacecourseDTO getRacecourse() {
        return racecourse;
    }

    public void setRacecourse(RacecourseDTO racecourse) {
        this.racecourse = racecourse;
    }

    public RaceCardDTO getRaceCard() {
        return raceCard;
    }

    public void setRaceCard(RaceCardDTO raceCard) {
        this.raceCard = raceCard;
    }

    public RaceDetailDTO getRaceDetail() {
        return raceDetail;
    }

    public void setRaceDetail(RaceDetailDTO raceDetail) {
        this.raceDetail = raceDetail;
    }

    public HorseDTO getHorse() {
        return horse;
    }

    public void setHorse(HorseDTO horse) {
        this.horse = horse;
    }

    @Override
    public String toString() {
        return "BetWrapperDTO{" +
                "bet=" + bet +
                ", event=" + event +
                ", racecourse=" + racecourse +
                ", raceCard=" + raceCard +
                ", raceDetail=" + raceDetail +
                ", horse=" + horse +
                '}';
    }
}
