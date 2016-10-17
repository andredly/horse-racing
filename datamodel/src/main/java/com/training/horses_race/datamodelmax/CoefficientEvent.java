package com.training.horses_race.datamodelmax;

/**
 * Created by ivc4 on 17.10.2016.
 */
public class CoefficientEvent extends AbstractModel {
    private Double coefficient;

//    private Bookmaker bookmaker;
//    private Event event;


    public CoefficientEvent() {
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }
}
