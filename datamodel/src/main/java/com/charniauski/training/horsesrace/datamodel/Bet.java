package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;
@Entity(tableName = "bet")
public class Bet extends AbstractModel{

    @Column(columnName = "date")
    private Date dateBet;
    @Column(columnName = "bet_type")
    private String betType;
    @Column(columnName = "sum")
    private Double sum;
    @Column(columnName = "coefficient_bet")
    private Double coefficientBet;
    @Column(columnName = "status_bet")
    private String statusBet;
    @Column(columnName = "calculate")
    private Double calculate;

//    private User user;
//    private Event event;


    public Bet() {
    }

    public String getBetType() {
        return betType;
    }

    public void setBetType(String betType) {
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

    public Double getCalculate() {
        return calculate;
    }

    public void setCalculate(Double calculate) {
        this.calculate = calculate;
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
