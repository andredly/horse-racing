package com.charniauski.training.horsesrace.web.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class RaceCardDTO {

    private Long id;

    @NotNull
    private Date dateStart;

    private Date dateFinish;

    @NotBlank
    private String raceType;

    @NotNull
    private Long racecourseId;

//    private Racecourse racecourse;
//    private RaceDetail raceDetail;

    public RaceCardDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                " id=" + id +
                " dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", raceType='" + raceType + '\'' +
                ", racecourseId=" + racecourseId +
                '}';
    }

}
