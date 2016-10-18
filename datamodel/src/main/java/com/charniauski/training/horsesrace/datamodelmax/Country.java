package com.charniauski.training.horsesrace.datamodelmax;

/**
 * Created by ivc4 on 17.10.2016.
 */
public class Country extends AbstractModel {
    private String locale;
    private String name;

//    private List<Racecourse> racecourses;

    public Country() {
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
