package com.charniauski.training.horsesrace.web.dto;

import com.charniauski.training.horsesrace.datamodel.enums.StatusBet;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class BetDTO {

    private Long id;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z", timezone="GMT")
    private Date dateBet;

    @NotNull
    private Long eventId;

    @NotNull
    private Long accountId;

    @NotNull
    @Min(0)
    private Double sum;

    private Double coefficientBet;

    private StatusBet statusBet;

    private Double calculate;

//    private User user;
//    private Event event;


    public BetDTO() {
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
                "id=" + id  +
                ", dateBet=" + dateBet +
                ", eventId=" + eventId +
                ", accountId=" + accountId +
                ", sum=" + sum +
                ", coefficientBet=" + coefficientBet +
                ", statusBet='" + statusBet + '\'' +
                ", calculate=" + calculate +
                '}';
    }

}
