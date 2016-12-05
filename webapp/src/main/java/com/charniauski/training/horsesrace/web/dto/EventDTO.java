package com.charniauski.training.horsesrace.web.dto;

import com.charniauski.training.horsesrace.datamodel.enums.EventType;
import com.charniauski.training.horsesrace.datamodel.enums.ResultEvent;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class EventDTO {

    private Long id;

    @NotNull
    private Long raceDetailId;

    @NotNull
    private EventType eventType;

    @Past
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z", timezone="GMT")
    private Date dateRegister;

    @NotNull
    @Min(0)
    private Double coefficientEvent;

    @NotBlank
    private String bookmaker;

    private ResultEvent resultEvent;

//    private RaceCard raceCard;
//    private Horse horse;

    public EventDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRaceDetailId() {
        return raceDetailId;
    }

    public void setRaceDetailId(Long raceDetailId) {
        this.raceDetailId = raceDetailId;
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
        return "Event{" +
                "id=" + id +
                ", raceDetailId=" + raceDetailId +
                ", eventType='" + eventType + '\'' +
                ", dateRegister=" + dateRegister +
                ", coefficientEvent=" + coefficientEvent +
                ", bookmaker='" + bookmaker + '\'' +
                ", resultEvent='" + resultEvent + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventDTO eventDTO = (EventDTO) o;

        if (id != null ? !id.equals(eventDTO.id) : eventDTO.id != null) return false;
        if (raceDetailId != null ? !raceDetailId.equals(eventDTO.raceDetailId) : eventDTO.raceDetailId != null)
            return false;
        if (eventType != eventDTO.eventType) return false;
        if (dateRegister != null ? !dateRegister.equals(eventDTO.dateRegister) : eventDTO.dateRegister != null)
            return false;
        if (coefficientEvent != null ? !coefficientEvent.equals(eventDTO.coefficientEvent) : eventDTO.coefficientEvent != null)
            return false;
        if (bookmaker != null ? !bookmaker.equals(eventDTO.bookmaker) : eventDTO.bookmaker != null) return false;
        return resultEvent == eventDTO.resultEvent;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (raceDetailId != null ? raceDetailId.hashCode() : 0);
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        result = 31 * result + (dateRegister != null ? dateRegister.hashCode() : 0);
        result = 31 * result + (coefficientEvent != null ? coefficientEvent.hashCode() : 0);
        result = 31 * result + (bookmaker != null ? bookmaker.hashCode() : 0);
        result = 31 * result + (resultEvent != null ? resultEvent.hashCode() : 0);
        return result;
    }
}
