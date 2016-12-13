package com.charniauski.training.horsesrace.web.dto.dtonew;

import com.charniauski.training.horsesrace.web.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class RaceCardDTO {

    private Long id;

    @NotNull
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z", timezone="GMT")
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date dateStart;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z", timezone="GMT")
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date dateFinish;

    @NotBlank
    private String raceType;

    private RacecourseDTO racecourseDTO;

    private List<RaceDetailDTO> raceDetailDTOList;

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

    public RacecourseDTO getRacecourseDTO() {
        return racecourseDTO;
    }

    public void setRacecourseDTO(RacecourseDTO racecourseDTO) {
        this.racecourseDTO = racecourseDTO;
    }

    public List<RaceDetailDTO> getRaceDetailDTOList() {
        return raceDetailDTOList;
    }

    public void setRaceDetailDTOList(List<RaceDetailDTO> raceDetailDTOList) {
        this.raceDetailDTOList = raceDetailDTOList;
    }

    @Override
    public String toString() {
        return "RaceCardDTO{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", raceType='" + raceType + '\'' +
                ", racecourseDTO=" + racecourseDTO +
                ", raceDetailDTOList=" + raceDetailDTOList +
                '}';
    }
}
