package com.charniauski.training.horsesrace.datamodel;

import com.charniauski.training.horsesrace.datamodel.annotation.Column;
import com.charniauski.training.horsesrace.datamodel.annotation.Entity;
import com.charniauski.training.horsesrace.datamodel.annotation.EnumType;
import com.charniauski.training.horsesrace.datamodel.enums.Status;

/**
 * Created by ivc4 on 13.10.2016.
 */
@Entity(tableName = "account", autoincrementColumn = "id")
public class Account extends AbstractModel{

    @Column(columnName = "login")
    private String login;

    @Column(columnName = "password")
    private String password;

    @EnumType(nameClass = Status.class)
    @Column(columnName = "status")
    private Status status;

    @Column(columnName = "balance")
    private Double balance;

    @Column(columnName = "email")
    private String email;

//    private SecurityLevel securityLevel;
//    private User user;

    public Account() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + getId() + '\'' +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;
        if (getId() != null ? !getId().equals(account.getId()) : account.getId() != null) return false;
        if (login != null ? !login.equals(account.login) : account.login != null) return false;
        if (password != null ? !password.equals(account.password) : account.password != null) return false;
        if (status != null ? !status.equals(account.status) : account.status != null)
            return false;
        if (balance != null ? !balance.equals(account.balance) : account.balance != null) return false;
        return email != null ? email.equals(account.email) : account.email == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
