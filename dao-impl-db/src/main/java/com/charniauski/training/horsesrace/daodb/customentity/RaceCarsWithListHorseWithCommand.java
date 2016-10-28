package com.charniauski.training.horsesrace.daodb.customentity;

import com.charniauski.training.horsesrace.datamodel.RaceCard;
import com.charniauski.training.horsesrace.datamodel.RaceDetail;

import java.util.List;

/**
 * Created by ivc4 on 28.10.2016.
 */
public class RaceCarsWithListHorseWithCommand {
    private RaceCard raceCard;
    private List<RaceDetail> raceDetail;

    public RaceCarsWithListHorseWithCommand() {
    }

    public RaceCard getRaceCard() {
        return raceCard;
    }

    public void setRaceCard(RaceCard raceCard) {
        this.raceCard = raceCard;
    }

    public List<RaceDetail> getRaceDetail() {
        return raceDetail;
    }

    public void setRaceDetail(List<RaceDetail> raceDetail) {
        this.raceDetail = raceDetail;
    }
}
