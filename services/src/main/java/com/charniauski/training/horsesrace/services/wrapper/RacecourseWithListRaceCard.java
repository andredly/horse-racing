package com.charniauski.training.horsesrace.services.wrapper;

import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.Racecourse;

import java.util.List;

/**
 * Created by ivc4 on 31.10.2016.
 */
public class RacecourseWithListRaceCard {
    private Racecourse racecourse;
    private List<RaceCard> raceCardList;

    public Racecourse getRacecourse() {
        return racecourse;
    }

    public void setRacecourse(Racecourse racecourse) {
        this.racecourse = racecourse;
    }

    public List<RaceCard> getRaceCardList() {
        return raceCardList;
    }

    public void setRaceCardList(List<RaceCard> raceCardList) {
        this.raceCardList = raceCardList;
    }

    public RacecourseWithListRaceCard() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RacecourseWithListRaceCard that = (RacecourseWithListRaceCard) o;

        if (racecourse != null ? !racecourse.equals(that.racecourse) : that.racecourse != null) return false;
        return raceCardList != null ? raceCardList.equals(that.raceCardList) : that.raceCardList == null;

    }

    @Override
    public int hashCode() {
        int result = racecourse != null ? racecourse.hashCode() : 0;
        result = 31 * result + (raceCardList != null ? raceCardList.hashCode() : 0);
        return result;
    }
}
