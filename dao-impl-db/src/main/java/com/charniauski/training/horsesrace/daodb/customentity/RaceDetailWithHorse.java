package com.charniauski.training.horsesrace.daodb.customentity;

import com.charniauski.training.horsesrace.datamodel.Horse;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;

/**
 * Created by ivc4 on 28.10.2016.
 */
public class RaceDetailWithHorse {
    private RaceDetail raceDetail;
    private Horse horse;

    public RaceDetailWithHorse() {
    }

    public RaceDetail getRaceDetail() {
        return raceDetail;
    }

    public void setRaceDetail(RaceDetail raceDetail) {
        this.raceDetail = raceDetail;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }
}
