package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;
@Entity(tableName = "bet")
public class Bet extends AbstractModel{
    @Column(columnName = "id",isAutoIncrement = true)
    private Long id;


    @Column(columnName = "date")
    private Date dateBet;
    @Column(columnName = "event_id")
    private Long eventId;
    @Column(columnName = "client_id")
    private Long clientId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateBet() {
        return dateBet;
    }

    public void setDateBet(Date dateBet) {
        this.dateBet = dateBet;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getBetType() {
        return betType;
    }

    public void setBetType(String betType) {
        this.betType = betType;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
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

    public Double getCalculate() {
        return calculate;
    }

    public void setCalculate(Double calculate) {
        this.calculate = calculate;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "id='" + id + '\'' +
                "dateBet=" + dateBet +
                ", betType='" + betType + '\'' +
                ", sum=" + sum +
                ", coefficientBet=" + coefficientBet +
                ", statusBet='" + statusBet + '\'' +
                ", calculate=" + calculate +
                '}';
    }
}
