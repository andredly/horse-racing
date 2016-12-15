package com.charniauski.training.horsesrace.web.dto.wrapper;

import com.charniauski.training.horsesrace.web.dto.RaceCardDTO;
import com.charniauski.training.horsesrace.web.dto.RacecourseDTO;

import java.util.List;

/**
 * Created by Andre on 05.11.2016.
 */
public class RacecourseWrapperDTO {
    private RacecourseDTO racecourse;
    private List<RaceCardDTO> raceCards;


    public void setRacecourse(RacecourseDTO racecourse) {
        this.racecourse = racecourse;
    }

    public void setRaceCards(List<RaceCardDTO> raceCards) {
        this.raceCards = raceCards;
    }

    public RacecourseDTO getRacecourse() {
        return racecourse;
    }

    public List<RaceCardDTO> getRaceCards() {
        return raceCards;
    }

    @Override
    public String toString() {
        return "RacecourseWrapperDTO{" +
                "racecourse=" + racecourse +
                ", raceCards=" + raceCards +
                '}';
    }
}
