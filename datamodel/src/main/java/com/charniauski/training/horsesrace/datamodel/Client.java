package com.charniauski.training.horsesrace.datamodel;

import java.util.Date;

import static com.charniauski.training.horsesrace.datamodel.Column.DataType.DATE;
import static com.charniauski.training.horsesrace.datamodel.Column.DataType.VARCHAR;

@Entity(tableName = "client")
public class Client extends AbstractModel {

    @Column(columnName = "first_name", dataType = VARCHAR)
    private String firstName;
    @Column(columnName = "last_name", dataType = VARCHAR)
    private String lastName;
    @Column(columnName = "date", dataType = DATE)
    private Date date;
    @Column(columnName = "address", dataType = VARCHAR)
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

    @Override
    public String toString() {
        return "Client{" +
                "id='"+getId()+ '\''+
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date=" + date +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;
        if (getId() != null ? !getId().equals(client.getId()) : client.getId() != null) return false;
        if (firstName != null ? !firstName.equals(client.firstName) : client.firstName != null) return false;
        if (lastName != null ? !lastName.equals(client.lastName) : client.lastName != null) return false;
        if (date != null ? !date.equals(client.date) : client.date != null) return false;
        return address != null ? address.equals(client.address) : client.address == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
