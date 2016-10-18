package com.charniauski.training.horsesrace.datamodelmax;

import java.util.Date;

public class RaceCard extends AbstractModel {
    private Date dateRace;
    private Integer counterHorse;
    private Integer distance;

//    private Racecourse racecourse;
//    private RaceDetail raceDetail;
//    private CoefficientEw coefficientEw;
    private CoverageType coverageType;
    private RaceType raceType;


    public RaceCard() {
    }

    public Date getDateRace() {
        return dateRace;
    }

    public void setDateRace(Date dateRace) {
        this.dateRace = dateRace;
    }

    public Integer getCounterHorse() {
        return counterHorse;
    }

    public void setCounterHorse(Integer counterHorse) {
        this.counterHorse = counterHorse;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public CoverageType getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(CoverageType coverageType) {
        this.coverageType = coverageType;
    }

    public RaceType getRaceType() {
        return raceType;
    }

    public void setRaceType(RaceType raceType) {
        this.raceType = raceType;
    }

    private enum CoverageType{

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
}
