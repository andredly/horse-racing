package com.charniauski.training.horsesrace.web.dto.dtonew;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * Created by ivc4 on 19.10.2016.
 */
public class RacecourseDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String country;

    private List<RaceCardDTO> raceCardDTOs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<RaceCardDTO> getRaceCardDTOs() {
        return raceCardDTOs;
    }

    public void setRaceCardDTOs(List<RaceCardDTO> raceCardDTOs) {
        this.raceCardDTOs = raceCardDTOs;
    }

    @Override
    public String toString() {
        return "RacecourseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", raceCardDTOs=" + raceCardDTOs +
                '}';
    }
}
