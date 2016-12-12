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


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RacecourseWrapper that = (RacecourseWrapper) o;

        if (racecourse != null ? !racecourse.equals(that.racecourse) : that.racecourse != null) return false;
        return raceCards != null ? raceCards.equals(that.raceCards) : that.raceCards == null;

    }

    @Override
    public int hashCode() {
        int result = racecourse != null ? racecourse.hashCode() : 0;
        result = 31 * result + (raceCards != null ? raceCards.hashCode() : 0);
        return result;
    }
}
