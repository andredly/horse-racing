package com.charniauski.training.horsesrace.web.dto.dtonew;

import com.charniauski.training.horsesrace.datamodel.enums.StatusBet;
import com.charniauski.training.horsesrace.web.dto.*;
import com.charniauski.training.horsesrace.web.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class BetDTO {

    private Long id;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z", timezone="GMT")
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date dateBet;

    @NotNull
    @Min(0)
    private Double sum;

    private Double coefficientBet;

    private StatusBet statusBet;

    private Double calculate;

    private EventDTO eventDTO;

    private AccountDTO accountDTO;

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

    public EventDTO getEventDTO() {
        return eventDTO;
    }

    public void setEventDTO(EventDTO eventDTO) {
        this.eventDTO = eventDTO;
    }

    public AccountDTO getAccountDTO() {
        return accountDTO;
    }

    public void setAccountDTO(AccountDTO accountDTO) {
        this.accountDTO = accountDTO;
    }
}
