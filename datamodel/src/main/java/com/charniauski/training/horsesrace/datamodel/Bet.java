package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;

public class Bet extends AbstractModel{

    private Date dateBet;
    private String typeBet;
    private Double sum;
    private Boolean isWin;
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

    public String getTypeBet() {
        return typeBet;
    }

    public void setTypeBet(String typeBet) {
        this.typeBet = typeBet;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Boolean getWin() {
        return isWin;
    }

    public void setWin(Boolean win) {
        isWin = win;
    }

    public Double getCalculation() {
        return calculation;
    }

    public void setCalculation(Double calculation) {
        this.calculation = calculation;
    }

}
