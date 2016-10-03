package racers.entity.racesobject.racecousce;

import racers.entity.racesobject.Racecard;
import racers.entity.racesobject.RaceObject;

import java.util.Date;
import java.util.List;

class HorseRaceCard implements Racecard{
    private int idRacecard;
    private RaceObject raceObject;
    private Date date;
    private List<Horse> horseList;
    private String distance;
    private int counterHorse;

    public HorseRaceCard() {
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

    private enum CoverageType {
        FIRM ("Firm"), GOOD_TO_FIRM("Good to firm"), GOOD("Good"), GOOD_TO_SOFT("Good to soft"),SOFT ("Soft"),
        SOFT_TO_HEAVY("Soft to heavy"), HEAVY("Heavy"), FAST("Fast"), STANDART("Standard"), SLOW("Slow");
        private String coverageType;
        CoverageType(String coverageType) {
            this.coverageType=coverageType;
        }

        static public CoverageType getType(String coverageType) {
            for (CoverageType type : CoverageType.values()) {
                if (type.getTypeValue().equals(coverageType)) {
                    return type;
                }
            }
            return null;
        }

        public String getTypeValue() {
            return coverageType;
        }
    }

    public int getIdRacecard() {
        return idRacecard;
    }

    public void setIdRacecard(int idRacecard) {
        this.idRacecard = idRacecard;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Horse> getHorseList() {
        return horseList;
    }

    public void setHorseList(List<Horse> horseList) {
        this.horseList = horseList;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getCounterHorse() {
        return counterHorse;
    }

    public void setCounterHorse(int counterHorse) {
        this.counterHorse = counterHorse;
    }

    public RaceObject getRaceObject() {
        return raceObject;
    }

    public void setRaceObject(RaceObject raceObject) {
        this.raceObject = raceObject;
    }
}
