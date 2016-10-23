package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;

@Entity(tableName = "client")
public class Client extends AbstractModel{

    @Column(columnName = "first_name")
    private String firstName;
    @Column(columnName = "last_name")
    private String lastName;
    @Column(columnName = "gender")
    private String gender;
    @Column(columnName = "date")
    private Date date;
    @Column(columnName = "address")
    private String address;


//    private Account account;
//    private List<Bet> bets;

    public Client() {
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

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", date=" + date +
                ", address='" + address + '\'' +
                '}';
    }
}
