package racers.entity.racesobject.racecousce;

import racers.entity.racesobject.RaceCard;
import racers.entity.racesobject.RaceObject;

import java.util.Date;

class HorseRaceCard implements RaceCard{
    private int idRacecard;
    private Date dateRace;
//    private List<Horse> horseList;
    private String distance;
    private int counterHorse;
    private RaceObject raceObject;
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

    public Date getDateRace() {
        return dateRace;
    }

    public void setDateRace(Date dateRace) {
        this.dateRace = dateRace;
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
