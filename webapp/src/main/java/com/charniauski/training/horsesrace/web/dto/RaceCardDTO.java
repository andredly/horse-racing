package com.charniauski.training.horsesrace.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class RaceCardDTO {

    private Long id;

    @NotNull
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z", timezone="GMT")
    private Date dateStart;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z", timezone="GMT")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceCardDTO that = (RaceCardDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dateStart != null ? !dateStart.equals(that.dateStart) : that.dateStart != null) return false;
        if (dateFinish != null ? !dateFinish.equals(that.dateFinish) : that.dateFinish != null) return false;
        if (raceType != null ? !raceType.equals(that.raceType) : that.raceType != null) return false;
        return racecourseId != null ? racecourseId.equals(that.racecourseId) : that.racecourseId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (dateFinish != null ? dateFinish.hashCode() : 0);
        result = 31 * result + (raceType != null ? raceType.hashCode() : 0);
        result = 31 * result + (racecourseId != null ? racecourseId.hashCode() : 0);
        return result;
    }
}
