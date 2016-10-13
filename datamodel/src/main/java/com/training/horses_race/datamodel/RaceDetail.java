package com.training.horses_race.datamodel;

import java.util.Date;
import java.util.List;

public class RaceDetail extends AbstractModel{
    private int numberStartBox;
    private Date dateFinish;
    private int result;
    private Horse horse;
    private RaceCard raceCard;

    public RaceDetail() {
    }

    public RaceCard getRaceCard() {
        return raceCard;
    }

    public void setRaceCard(RaceCard raceCard) {
        this.raceCard = raceCard;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public int getNumberStartBox() {
        return numberStartBox;
    }

    public void setNumberStartBox(int numberStartBox) {
        this.numberStartBox = numberStartBox;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
