package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;

public class RaceCard extends AbstractModel {
    private Date dateStartRace;
    private Date dateFinishRace;
    private String raceType;
    private Integer counterHorse;


//    private Racecourse racecourse;
//    private RaceDetail raceDetail;

    public RaceCard() {
    }


    public Date getDateStartRace() {
        return dateStartRace;
    }

    public void setDateStartRace(Date dateStartRace) {
        this.dateStartRace = dateStartRace;
    }

    public Integer getCounterHorse() {
        return counterHorse;
    }

    public void setCounterHorse(Integer counterHorse) {
        this.counterHorse = counterHorse;
    }

    public Date getDateFinishRace() {
        return dateFinishRace;
    }

    public void setDateFinishRace(Date dateFinishRace) {
        this.dateFinishRace = dateFinishRace;
    }

    public String getRaceType() {
        return raceType;
    }

    public void setRaceType(String raceType) {
        this.raceType = raceType;
    }
}
