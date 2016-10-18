package com.charniauski.training.horsesrace.datamodelmax;

import java.util.Date;

public class Event extends AbstractModel {

    private Date dateRegister;

//    private RaceCard raceCard;
//    private Horse horse;
//    private EventType eventType;
//    private EventTypeGroup eventTypeGroup;
//    private CoefficientEvent coefficientEvent;

    public Event() {
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

}
