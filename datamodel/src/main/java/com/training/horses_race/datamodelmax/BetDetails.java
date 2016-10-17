package com.training.horses_race.datamodelmax;

/**
 * Created by ivc4 on 17.10.2016.
 */
public class BetDetails {
    private Double sumMin;
    private Double sumMax;
    private String betType;

    public BetDetails() {
    }

    public Double getSumMin() {
        return sumMin;
    }

    public void setSumMin(Double sumMin) {
        this.sumMin = sumMin;
    }

    public Double getSumMax() {
        return sumMax;
    }

    public void setSumMax(Double sumMax) {
        this.sumMax = sumMax;
    }

    public String getBetType() {
        return betType;
    }

    public void setBetType(String betType) {
        this.betType = betType;
    }
}
