package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;
@Entity(tableName = "bet", autoincrementColumn = "id")
public class Bet extends AbstractModel{

    @Column(columnName = "date")
    private Date dateBet;
    @Column(columnName = "event_id")
    private Long eventId;
    @Column(columnName = "account_id")
    private Long accountId;
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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
                "id='" + getId() + '\'' +
                ", dateBet=" + dateBet +
                ", betType='" + betType + '\'' +
                ", sum=" + sum +
                ", coefficientBet=" + coefficientBet +
                ", statusBet='" + statusBet + '\'' +
                ", calculate=" + calculate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bet bet = (Bet) o;

        if (dateBet != null ? !dateBet.equals(bet.dateBet) : bet.dateBet != null) return false;
        if (eventId != null ? !eventId.equals(bet.eventId) : bet.eventId != null) return false;
        if (accountId != null ? !accountId.equals(bet.accountId) : bet.accountId != null) return false;
        if (betType != null ? !betType.equals(bet.betType) : bet.betType != null) return false;
        if (sum != null ? !sum.equals(bet.sum) : bet.sum != null) return false;
        if (coefficientBet != null ? !coefficientBet.equals(bet.coefficientBet) : bet.coefficientBet != null)
            return false;
        if (statusBet != null ? !statusBet.equals(bet.statusBet) : bet.statusBet != null) return false;
        return calculate != null ? calculate.equals(bet.calculate) : bet.calculate == null;

    }

    @Override
    public int hashCode() {
        int result = dateBet != null ? dateBet.hashCode() : 0;
        result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (betType != null ? betType.hashCode() : 0);
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        result = 31 * result + (coefficientBet != null ? coefficientBet.hashCode() : 0);
        result = 31 * result + (statusBet != null ? statusBet.hashCode() : 0);
        result = 31 * result + (calculate != null ? calculate.hashCode() : 0);
        return result;
    }
}
