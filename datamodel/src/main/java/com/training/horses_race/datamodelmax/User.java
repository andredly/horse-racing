package com.training.horses_race.datamodelmax;

import java.util.Date;
import java.util.List;

public class User extends AbstractModel {
    private String firstName;
    private String lastName;
    private Date date;
    private String gender;

//    private Address address;
//    private Account account;
//    private List<Bet> bets;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
