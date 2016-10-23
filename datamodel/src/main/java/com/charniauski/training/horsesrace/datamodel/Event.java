package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;

@Entity(tableName = "event")
public class Event extends AbstractModel {
    @Column(columnName = "event_type")
    private String eventType;
    @Column(columnName = "date_register")
    private Date dateRegister;
    @Column(columnName = "coefficient_event")
    private Double coefficientEvent;
    @Column(columnName = "bookmaker")
    private String bookmaker;
    @Column(columnName = "result_event")
    private String resultEvent;

//    private RaceCard raceCard;
//    private Horse horse;

    public Event() {
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
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

    public String getResultEvent() {
        return resultEvent;
    }

    public void setResultEvent(String resultEvent) {
        this.resultEvent = resultEvent;
    }
}
