package com.charniauski.training.horsesrace.web.dto;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by ivc4 on 19.10.2016.
 */
public class RacecourseDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String country;

    //    private List<Racecourse> racecourses;


    public RacecourseDTO() {
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
