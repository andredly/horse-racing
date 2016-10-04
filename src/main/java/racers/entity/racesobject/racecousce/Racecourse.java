package racers.entity.racesobject.racecousce;

import racers.entity.racesobject.Country;
import racers.entity.racesobject.RaceObject;

import java.util.List;

public class Racecourse implements RaceObject {
    private int id;
    private String name;
    private Country country;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<HorseRaceCard> getListRacers() {
        return listRacers;
    }

    public void setListRacers(List<HorseRaceCard> listRacers) {
        this.listRacers = listRacers;
    }
}
