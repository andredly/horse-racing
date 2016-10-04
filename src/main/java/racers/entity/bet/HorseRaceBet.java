package racers.entity.bet;


import racers.entity.user.User;

import java.util.Date;

public class HorseRaceBet implements Bet{
    private int idBet;
    private LineEvent lineEvent;
    private User user;
    private float sum;
    private Date dateBet;
    private boolean isEnableBetEW;
    private float coefficient;
    private float coefficientEW;
    private float calculation;

    public HorseRaceBet() {
    }

    public long getIdBet() {
        return idBet;
    }

    public void setIdBet(int idBet) {
        this.idBet = idBet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public Date getDateBet() {
        return dateBet;
    }

    public void setDateBet(Date dateBet) {
        this.dateBet = dateBet;
    }

    public boolean isEnableBetEW() {
        return isEnableBetEW;
    }

    public void setEnableBetEW(boolean enableBetEW) {
        isEnableBetEW = enableBetEW;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public float getCoefficientEW() {
        return coefficientEW;
    }

    public void setCoefficientEW(float coefficientEW) {
        this.coefficientEW = coefficientEW;
    }

    public float getCalculation() {
        return calculation;
    }

    public void setCalculation(float calculation) {
        this.calculation = calculation;
    }

    @Override
    public boolean isWinning() {
        // TODO: 04.10.2016
        return false;
    }

    @Override
    public int calculateWinnings() {
        //TODO: 04.10.2016
        return 0;
    }
}
