package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;

@Entity(tableName = "race_card", autoincrementColumn = "id")
public class RaceCard extends AbstractModel {

    @Column(columnName = "date_start")
    private Date dateStart;
    @Column(columnName = "date_finish")
    private Date dateFinish;
    @Column(columnName = "race_type")
    private String raceType;
    @Column(columnName = "racecourse_id")
    private Long racecourseId;

//    private Racecourse racecourse;
//    private RaceDetail raceDetail;

    public RaceCard() {
    }


    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String getRaceType() {
        return raceType;
    }

    public void setRaceType(String raceType) {
        this.raceType = raceType;
    }

    public Long getRacecourseId() {
        return racecourseId;
    }

    public void setRacecourseId(Long racecourseId) {
        this.racecourseId = racecourseId;
    }

    @Override
    public String toString() {
        return "RaceCard{" +
                "id='" + getId() + '\'' +
                "dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", raceType='" + raceType + '\'' +
                '}';
    }
}
