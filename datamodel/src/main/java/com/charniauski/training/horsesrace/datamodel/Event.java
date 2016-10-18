package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;

public class Event extends AbstractModel{
    private String eventType;
    private Date dateRegister;
    private Double coefficientEvent;
    private String bookmaker;

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
}
