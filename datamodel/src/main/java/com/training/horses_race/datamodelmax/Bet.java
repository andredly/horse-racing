

package com.training.horses_race.datamodelmax;

import java.util.Date;

public class Bet extends AbstractModel {

    private Date dateBet;
    private Double sum;
    private Boolean isWin;
    private Boolean ewIsEnable;
    private Double calculation;

//    private User user;
//    private Event event;
//    private BetDetails betDetails;


    public Bet() {
    }

    public Date getDateBet() {
        return dateBet;
    }

    public void setDateBet(Date dateBet) {
        this.dateBet = dateBet;
    }

    public Boolean getEwIsEnable() {
        return ewIsEnable;
    }

    public void setEwIsEnable(Boolean ewIsEnable) {
        this.ewIsEnable = ewIsEnable;
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


    public Double calculateWinnings() {
        //TODO: 04.10.2016
        return null;
    }
}
