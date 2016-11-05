package com.charniauski.training.horsesrace.datamodel;

import com.charniauski.training.horsesrace.datamodel.annotation.Column;
import com.charniauski.training.horsesrace.datamodel.annotation.Entity;
import com.charniauski.training.horsesrace.datamodel.annotation.EnumType;
import com.charniauski.training.horsesrace.datamodel.enums.StatusBet;

import java.util.Date;
@Entity(tableName = "bet", autoincrementColumn = "id")
public class Bet extends AbstractModel{

    @Column(columnName = "date_bet")
    private Date dateBet;

    @Column(columnName = "event_id")
    private Long eventId;

    @Column(columnName = "account_id")
    private Long accountId;

    @Column(columnName = "sum")
    private Double sum;

    @Column(columnName = "coefficient_bet")
    private Double coefficientBet;

    @EnumType(nameClass = StatusBet.class)
    @Column(columnName = "status_bet")
    private StatusBet statusBet;

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

    public StatusBet getStatusBet() {
        return statusBet;
    }

    public void setStatusBet(StatusBet statusBet) {
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
                "id=" + getId()  +
                ", dateBet=" + dateBet +
                ", eventId=" + eventId +
                ", accountId=" + accountId +
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
        if (getId() != null ? !getId().equals(bet.getId()) : bet.getId() != null) return false;
        if (dateBet != null ? !dateBet.equals(bet.dateBet) : bet.dateBet != null) return false;
        if (eventId != null ? !eventId.equals(bet.eventId) : bet.eventId != null) return false;
        if (accountId != null ? !accountId.equals(bet.accountId) : bet.accountId != null) return false;
        if (sum != null ? !sum.equals(bet.sum) : bet.sum != null) return false;
        if (coefficientBet != null ? !coefficientBet.equals(bet.coefficientBet) : bet.coefficientBet != null)
            return false;
        if (statusBet != null ? !statusBet.equals(bet.statusBet) : bet.statusBet != null) return false;
        return calculate != null ? calculate.equals(bet.calculate) : bet.calculate == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (dateBet != null ? dateBet.hashCode() : 0);
        result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        result = 31 * result + (coefficientBet != null ? coefficientBet.hashCode() : 0);
        result = 31 * result + (statusBet != null ? statusBet.hashCode() : 0);
        result = 31 * result + (calculate != null ? calculate.hashCode() : 0);
        return result;
    }
}
