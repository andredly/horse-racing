package com.charniauski.training.horsesrace.datamodel;

import com.charniauski.training.horsesrace.datamodel.annotation.Column;
import com.charniauski.training.horsesrace.datamodel.annotation.Entity;
import com.charniauski.training.horsesrace.datamodel.annotation.EnumType;
import com.charniauski.training.horsesrace.datamodel.enums.EventType;
import com.charniauski.training.horsesrace.datamodel.enums.ResultEvent;

import java.util.Date;

@Entity(tableName = "event", autoincrementColumn = "id")
public class Event extends AbstractModel {

    @Column(columnName = "race_detail_id")
    private Long raceDetailId;

    @EnumType(nameClass = EventType.class)
    @Column(columnName = "event_type")
    private EventType eventType;

    @Column(columnName = "date_register")
    private Date dateRegister;

    @Column(columnName = "coefficient_event")
    private Double coefficientEvent;

    @Column(columnName = "bookmaker")
    private String bookmaker;

    @EnumType(nameClass = ResultEvent.class)
    @Column(columnName = "result_event")
    private ResultEvent resultEvent;

//    private RaceCard raceCard;
//    private Horse horse;

    public Event() {
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
                "id=" + getId() +
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

        Event event = (Event) o;
        if (getId() != null ? !getId().equals(event.getId()) : event.getId() != null) return false;
        if (raceDetailId != null ? !raceDetailId.equals(event.raceDetailId) : event.raceDetailId != null) return false;
        if (eventType != null ? !eventType.equals(event.eventType) : event.eventType != null) return false;
        if (dateRegister != null ? !dateRegister.equals(event.dateRegister) : event.dateRegister != null) return false;
        if (coefficientEvent != null ? !coefficientEvent.equals(event.coefficientEvent) : event.coefficientEvent != null)
            return false;
        if (bookmaker != null ? !bookmaker.equals(event.bookmaker) : event.bookmaker != null) return false;
        return resultEvent != null ? resultEvent.equals(event.resultEvent) : event.resultEvent == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (raceDetailId != null ? raceDetailId.hashCode() : 0);
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        result = 31 * result + (dateRegister != null ? dateRegister.hashCode() : 0);
        result = 31 * result + (coefficientEvent != null ? coefficientEvent.hashCode() : 0);
        result = 31 * result + (bookmaker != null ? bookmaker.hashCode() : 0);
        result = 31 * result + (resultEvent != null ? resultEvent.hashCode() : 0);
        return result;
    }
}
