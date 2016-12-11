package com.charniauski.training.horsesrace.web.dto.wrapper;

import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.web.dto.RaceCardDTO;
import com.charniauski.training.horsesrace.web.dto.RacecourseDTO;

import java.util.List;

/**
 * Created by Andre on 05.11.2016.
 */
public class RaceCardWrapperDTO {
    private RaceCardDTO raceCard;
    private RacecourseDTO racecourse;
    private List<RaceDetailWrapperDTO> raceDetailWrappers;

    public void setRaceCard(RaceCardDTO raceCard) {
        this.raceCard = raceCard;
    }

    public void setRacecourse(RacecourseDTO racecourse) {
        this.racecourse = racecourse;
    }

    public void setRaceDetailWrappers(List<RaceDetailWrapperDTO> raceDetailWrappers) {
        this.raceDetailWrappers = raceDetailWrappers;
    }

    @Override
    public String toString() {
        return "RaceCardWrapperDTO{" +
                "raceCard=" + raceCard +
                ", racecourse=" + racecourse +
                ", raceDetailWrappers=" + raceDetailWrappers +
                '}';
    }
}
