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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RacecourseWrapper)) return false;

        RacecourseWrapper that = (RacecourseWrapper) o;

        if (racecourse != null ? !racecourse.equals(that.racecourse) : that.racecourse != null) return false;
        return raceCardWrappers != null ? raceCardWrappers.equals(that.raceCardWrappers) : that.raceCardWrappers == null;

    }

    @Override
    public int hashCode() {
        int result = racecourse != null ? racecourse.hashCode() : 0;
        result = 31 * result + (raceCardWrappers != null ? raceCardWrappers.hashCode() : 0);
        return result;
    }
}
