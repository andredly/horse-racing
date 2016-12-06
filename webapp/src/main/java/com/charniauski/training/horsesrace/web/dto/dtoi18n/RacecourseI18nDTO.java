package com.charniauski.training.horsesrace.web.dto.dtoi18n;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by ivc4 on 19.10.2016.
 */
public class RacecourseI18nDTO {

    private Long id;

    private String name;

    private String country;

    //    private List<Racecourse> racecourses;


    public RacecourseI18nDTO() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Racecourse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
