package com.charniauski.training.horsesrace.services.wrapper;

import com.charniauski.training.horsesrace.datamodel.*;

public class BetWrapper {

    private Bet bet;
    private Event event;
    private Racecourse racecourse;
    private RaceCard raceCard;
    private RaceDetail raceDetail;
    private Horse horse;

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Racecourse getRacecourse() {
        return racecourse;
    }

    public void setRacecourse(Racecourse racecourse) {
        this.racecourse = racecourse;
    }

    public RaceCard getRaceCard() {
        return raceCard;
    }

    public void setRaceCard(RaceCard raceCard) {
        this.raceCard = raceCard;
    }

    public RaceDetail getRaceDetail() {
        return raceDetail;
    }

    public void setRaceDetail(RaceDetail raceDetail) {
        this.raceDetail = raceDetail;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    @Override
    public String toString() {
        return "BetWrapper{" +
                "bet=" + bet +
                ", event=" + event +
                ", racecourse=" + racecourse +
                ", raceCard=" + raceCard +
                ", raceDetail=" + raceDetail +
                ", horse=" + horse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BetWrapper)) return false;

        BetWrapper that = (BetWrapper) o;

        if (bet != null ? !bet.equals(that.bet) : that.bet != null) return false;
        if (event != null ? !event.equals(that.event) : that.event != null) return false;
        if (racecourse != null ? !racecourse.equals(that.racecourse) : that.racecourse != null) return false;
        if (raceCard != null ? !raceCard.equals(that.raceCard) : that.raceCard != null) return false;
        if (raceDetail != null ? !raceDetail.equals(that.raceDetail) : that.raceDetail != null) return false;
        return horse != null ? horse.equals(that.horse) : that.horse == null;

    }

    @Override
    public int hashCode() {
        int result = bet != null ? bet.hashCode() : 0;
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (racecourse != null ? racecourse.hashCode() : 0);
        result = 31 * result + (raceCard != null ? raceCard.hashCode() : 0);
        result = 31 * result + (raceDetail != null ? raceDetail.hashCode() : 0);
        result = 31 * result + (horse != null ? horse.hashCode() : 0);
        return result;
    }
}
