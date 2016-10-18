package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;

public class RaceCard extends AbstractModel {
    private Date dateRace;
    private String racecourse;
    private Integer counterHorse;

    private RaceType raceType;
    private RaceDetail raceDetail;

    public RaceCard() {
    }

    public RaceDetail getRaceDetail() {
        return raceDetail;
    }

    public void setRaceDetail(RaceDetail raceDetail) {
        this.raceDetail = raceDetail;
    }

    private enum RaceType {
        FLAT("Flat Racing"),CHASE("Chase"), HURDLE("Hurdle"),NATIONAL_HUNT_FLAT_RACE("National Hunt Flat race");
        private String raceType;
        RaceType(String raceType) {
            this.raceType=raceType;
        }
        static public RaceType getType(String raceType) {
            for (RaceType type : RaceType.values()) {
                if (type.getTypeValue().equals(raceType)) {
                    return type;
                }
            }
            return null;
        }

        public String getTypeValue() {
            return raceType;
        }
    }


    public Date getDateRace() {
        return dateRace;
    }

    public void setDateRace(Date dateRace) {
        this.dateRace = dateRace;
    }

    public RaceType getRaceType() {
        return raceType;
    }

    public void setRaceType(RaceType raceType) {
        this.raceType = raceType;
    }

    public String getRacecourse() {
        return racecourse;
    }

    public void setRacecourse(String racecourse) {
        this.racecourse = racecourse;
    }

    public Integer getCounterHorse() {
        return counterHorse;
    }

    public void setCounterHorse(Integer counterHorse) {
        this.counterHorse = counterHorse;

    }
}
