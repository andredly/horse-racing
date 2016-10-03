package racers.entity.racesobject.racecousce;

import racers.entity.racesobject.RaceObject;

import java.util.List;

public class Racecourse implements RaceObject {
    private int id;
    private String name;
    private String country;
    private List<HorseRaceCard> listRacers;

    public Racecourse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
