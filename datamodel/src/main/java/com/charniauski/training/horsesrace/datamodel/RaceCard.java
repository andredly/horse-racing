package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;

@Entity(tableName = "race_card")
public class RaceCard extends AbstractModel {
    @Column(columnName = "date_start")
    private Date dateStartRace;
    @Column(columnName = "date_finish")
    private Date dateFinishRace;
    @Column(columnName = "race_type")
    private String raceType;

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
