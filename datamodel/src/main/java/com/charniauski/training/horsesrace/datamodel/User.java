package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;
import java.util.List;

public class User extends AbstractModel{
    private String firstName;
    private String lastName;
    private Date date;
    private String address;
    private String gender;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}