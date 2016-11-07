package com.charniauski.training.horsesrace.services.wrapper;

import com.charniauski.training.horsesrace.datamodel.Racecourse;

import java.util.List;

/**
 * Created by Andre on 05.11.2016.
 */
public class RacecourseWrapper {
    private Racecourse racecourse;
    private List<RaceCardWrapper> raceCardWrappers;

    public Racecourse getRacecourse() {
        return racecourse;
    }

    public void setRacecourse(Racecourse racecourse) {
        this.racecourse = racecourse;
    }

    public List<RaceCardWrapper> getRaceCardWrappers() {
        return raceCardWrappers;
    }

    public void setRaceCardWrappers(List<RaceCardWrapper> raceCardWrappers) {
        this.raceCardWrappers = raceCardWrappers;
    }
}
