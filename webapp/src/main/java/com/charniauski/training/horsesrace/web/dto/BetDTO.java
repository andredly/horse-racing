package com.charniauski.training.horsesrace.web.dto;

import com.charniauski.training.horsesrace.datamodel.enums.StatusBet;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BetDTO betDTO = (BetDTO) o;

        if (id != null ? !id.equals(betDTO.id) : betDTO.id != null) return false;
        if (dateBet != null ? !dateBet.equals(betDTO.dateBet) : betDTO.dateBet != null) return false;
        if (eventId != null ? !eventId.equals(betDTO.eventId) : betDTO.eventId != null) return false;
        if (accountId != null ? !accountId.equals(betDTO.accountId) : betDTO.accountId != null) return false;
        if (sum != null ? !sum.equals(betDTO.sum) : betDTO.sum != null) return false;
        if (coefficientBet != null ? !coefficientBet.equals(betDTO.coefficientBet) : betDTO.coefficientBet != null)
            return false;
        if (statusBet != betDTO.statusBet) return false;
        return calculate != null ? calculate.equals(betDTO.calculate) : betDTO.calculate == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
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
