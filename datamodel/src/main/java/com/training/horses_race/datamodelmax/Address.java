package com.training.horses_race.datamodelmax;

import com.training.horses_race.datamodel.*;

/**
 * Created by ivc4 on 17.10.2016.
 */
public class Address {
    private String city;
    private Integer postCode;
    private String homeAddress;

//    private User user;
//    private Country country;

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }
}
