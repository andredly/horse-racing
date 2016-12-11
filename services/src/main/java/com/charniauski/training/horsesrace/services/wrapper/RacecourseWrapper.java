package com.charniauski.training.horsesrace.services.wrapper;

import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.Racecourse;

import java.util.List;

/**
 * Created by Andre on 05.11.2016.
 */
public class RacecourseWrapper {
    private Racecourse racecourse;
    private List<RaceCard> raceCards;

    public Racecourse getRacecourse() {
        return racecourse;
    }

    public void setRacecourse(Racecourse racecourse) {
        this.racecourse = racecourse;
    }

    public List<RaceCard> getRaceCards() {
        return raceCards;
    }

    public void setRaceCards(List<RaceCard> raceCards) {
        this.raceCards = raceCards;
    }

    @Override
    public String toString() {
        return "RacecourseWrapper{" +
                "racecourse=" + racecourse +
                ", raceCards=" + raceCards +
                '}';
    }
}
