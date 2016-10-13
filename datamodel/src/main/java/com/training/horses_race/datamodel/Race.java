package com.training.horses_race.datamodel;

import java.util.Date;

public class Race extends AbstractModel{
    private int numberStartBox;
    private Date dateFinish;
    private int result;

    public Race() {
    }

    public int getNumberStartBox() {
        return numberStartBox;
    }

    public void setNumberStartBox(int numberStartBox) {
        this.numberStartBox = numberStartBox;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
