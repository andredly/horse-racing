package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;
import java.util.List;

public class RaceDetail extends AbstractModel{
    private Integer numberStartBox;
    private Date dateFinish;
    private Integer horseResult;

//    private List<Horse> horses;
//    private RaceCard raceCard;

    public RaceDetail() {
    }

    public Integer getNumberStartBox() {
        return numberStartBox;
    }

    public void setNumberStartBox(Integer numberStartBox) {
        this.numberStartBox = numberStartBox;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public Integer getHorseResult() {
        return horseResult;
    }

    public void setHorseResult(Integer horseResult) {
        this.horseResult = horseResult;
    }
}
