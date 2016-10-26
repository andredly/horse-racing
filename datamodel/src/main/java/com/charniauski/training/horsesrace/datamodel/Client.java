package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;

import static com.charniauski.training.horsesrace.datamodel.Column.DataType.DATE;
import static com.charniauski.training.horsesrace.datamodel.Column.DataType.VARCHAR;

@Entity(tableName = "client")
public class Client extends AbstractModel {
    @Column(columnName = "id",isAutoIncrement = true)
    private Long id;

    @Column(columnName = "first_name", dataType = VARCHAR)
    private String firstName;
    @Column(columnName = "last_name", dataType = VARCHAR)
    private String lastName;
    @Column(columnName = "gender", dataType = VARCHAR)
    private String gender;
    @Column(columnName = "date", dataType = DATE)
    private Date date;
    @Column(columnName = "address", dataType = VARCHAR)
    private String address;

//    private Account account;
//    private List<Bet> bets;

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id='"+id+ '\''+
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", date=" + date +
                ", address='" + address + '\'' +
                '}';
    }
}
