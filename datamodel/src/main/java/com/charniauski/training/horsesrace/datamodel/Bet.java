package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;

public class Bet extends AbstractModel{

    private Date dateBet;
    private Double sum;
    private Double coefficientBet;
    private String statusBet;
    private Double calculation;

//    private User user;
//    private Event event;
    private BetType betType;

    public Bet() {
    }

    public BetType getBetType() {
        return betType;
    }

    public void setBetType(BetType betType) {
        this.betType = betType;
    }

    public Date getDateBet() {
        return dateBet;
    }

    public void setDateBet(Date dateBet) {
        this.dateBet = dateBet;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getCalculation() {
        return calculation;
    }

    public void setCalculation(Double calculation) {
        this.calculation = calculation;
    }

    public Double getCoefficientBet() {
        return coefficientBet;
    }

    public void setCoefficientBet(Double coefficientBet) {
        this.coefficientBet = coefficientBet;
    }

    public String getStatusBet() {
        return statusBet;
    }

    public void setStatusBet(String statusBet) {
        this.statusBet = statusBet;
    }
}
