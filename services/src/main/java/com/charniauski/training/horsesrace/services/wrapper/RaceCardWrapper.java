package com.charniauski.training.horsesrace.services.wrapper;

import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.Racecourse;

import java.util.List;

/**
 * Created by Andre on 05.11.2016.
 */
public class RaceCardWrapper {
    private RaceCard raceCard;
    private Racecourse racecourse;
    private List<RaceDetailWrapper> raceDetailWrappers;

    public RaceCard getRaceCard() {
        return raceCard;
    }

    public void setRaceCard(RaceCard raceCard) {
        this.raceCard = raceCard;
    }

    public Racecourse getRacecourse() {
        return racecourse;
    }

    public void setRacecourse(Racecourse racecourse) {
        this.racecourse = racecourse;
    }

    public List<RaceDetailWrapper> getRaceDetailWrappers() {
        return raceDetailWrappers;
    }

    public void setRaceDetailWrappers(List<RaceDetailWrapper> raceDetailWrappers) {
        this.raceDetailWrappers = raceDetailWrappers;
    }
}
