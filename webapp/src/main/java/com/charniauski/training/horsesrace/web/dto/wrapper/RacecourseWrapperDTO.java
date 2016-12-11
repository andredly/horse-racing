package com.charniauski.training.horsesrace.web.dto.wrapper;

import com.charniauski.training.horsesrace.datamodel.Racecourse;
import com.charniauski.training.horsesrace.web.dto.RacecourseDTO;

import java.util.List;

/**
 * Created by Andre on 05.11.2016.
 */
public class RacecourseWrapperDTO {
    private RacecourseDTO racecourse;
    private List<RaceCardWrapperDTO> raceCardWrappers;


    public void setRacecourse(RacecourseDTO racecourse) {
        this.racecourse = racecourse;
    }

    public void setRaceCardWrappers(List<RaceCardWrapperDTO> raceCardWrappers) {
        this.raceCardWrappers = raceCardWrappers;
    }

    @Override
    public String toString() {
        return "RacecourseWrapperDTO{" +
                "racecourse=" + racecourse +
                ", raceCardWrappers=" + raceCardWrappers +
                '}';
    }
}
