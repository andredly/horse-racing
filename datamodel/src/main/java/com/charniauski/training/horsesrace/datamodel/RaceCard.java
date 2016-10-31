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
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", raceType='" + raceType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceCard raceCard = (RaceCard) o;

        if (dateStart != null ? !dateStart.equals(raceCard.dateStart) : raceCard.dateStart != null) return false;
        if (dateFinish != null ? !dateFinish.equals(raceCard.dateFinish) : raceCard.dateFinish != null) return false;
        if (raceType != null ? !raceType.equals(raceCard.raceType) : raceCard.raceType != null) return false;
        return racecourseId != null ? racecourseId.equals(raceCard.racecourseId) : raceCard.racecourseId == null;

    }

    @Override
    public int hashCode() {
        int result = dateStart != null ? dateStart.hashCode() : 0;
        result = 31 * result + (dateFinish != null ? dateFinish.hashCode() : 0);
        result = 31 * result + (raceType != null ? raceType.hashCode() : 0);
        result = 31 * result + (racecourseId != null ? racecourseId.hashCode() : 0);
        return result;
    }
}
