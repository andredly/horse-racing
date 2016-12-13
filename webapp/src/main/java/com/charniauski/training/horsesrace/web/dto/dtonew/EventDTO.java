package com.charniauski.training.horsesrace.web.dto.dtonew;

import com.charniauski.training.horsesrace.datamodel.RaceDetail;
import com.charniauski.training.horsesrace.datamodel.enums.EventType;
import com.charniauski.training.horsesrace.datamodel.enums.ResultEvent;
import com.charniauski.training.horsesrace.web.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class EventDTO {

    private Long id;

    private RaceDetailDTO raceDetailDTO;

    @NotNull
    private EventType eventType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Past
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z", timezone="GMT")
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date dateRegister;

    @NotNull
    @Min(0)
    private Double coefficientEvent;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotBlank
    private String bookmaker;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ResultEvent resultEvent;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RaceDetailDTO getRaceDetailDTO() {
        return raceDetailDTO;
    }

    public void setRaceDetailDTO(RaceDetailDTO raceDetailDTO) {
        this.raceDetailDTO = raceDetailDTO;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Double getCoefficientEvent() {
        return coefficientEvent;
    }

    public void setCoefficientEvent(Double coefficientEvent) {
        this.coefficientEvent = coefficientEvent;
    }

    public String getBookmaker() {
        return bookmaker;
    }

    public void setBookmaker(String bookmaker) {
        this.bookmaker = bookmaker;
    }

    public ResultEvent getResultEvent() {
        return resultEvent;
    }

    public void setResultEvent(ResultEvent resultEvent) {
        this.resultEvent = resultEvent;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "id=" + id +
                ", raceDetailDTO=" + raceDetailDTO +
                ", eventType=" + eventType +
                ", dateRegister=" + dateRegister +
                ", coefficientEvent=" + coefficientEvent +
                ", bookmaker='" + bookmaker + '\'' +
                ", resultEvent=" + resultEvent +
                '}';
    }
}
