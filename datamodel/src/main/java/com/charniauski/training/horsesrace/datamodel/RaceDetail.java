package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;
import java.util.List;

@Entity(tableName = "race_detail")
public class RaceDetail extends AbstractModel{
    @Column(columnName = "number_start_box")
    private Integer numberStartBox;
    @Column(columnName = "horse_result")
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

    public Integer getHorseResult() {
        return horseResult;
    }

    public void setHorseResult(Integer horseResult) {
        this.horseResult = horseResult;
    }
}
