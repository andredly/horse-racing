package com.charniauski.training.horsesrace.datamodel;

import java.util.List;

/**
 * Created by ivc4 on 19.10.2016.
 */
public class Racecourse  extends AbstractModel{
    private String name;
    private String country;

//    private List<Racecourse> racecourses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
