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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RaceCardWrapper)) return false;

        RaceCardWrapper that = (RaceCardWrapper) o;

        if (raceCard != null ? !raceCard.equals(that.raceCard) : that.raceCard != null) return false;
        if (racecourse != null ? !racecourse.equals(that.racecourse) : that.racecourse != null) return false;
        return raceDetailWrappers != null ? raceDetailWrappers.equals(that.raceDetailWrappers) : that.raceDetailWrappers == null;

    }

    @Override
    public int hashCode() {
        int result = raceCard != null ? raceCard.hashCode() : 0;
        result = 31 * result + (racecourse != null ? racecourse.hashCode() : 0);
        result = 31 * result + (raceDetailWrappers != null ? raceDetailWrappers.hashCode() : 0);
        return result;
    }
}
