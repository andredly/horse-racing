package com.charniauski.training.horsesrace.datamodel;

import com.charniauski.training.horsesrace.datamodel.annotation.Column;
import com.charniauski.training.horsesrace.datamodel.annotation.Entity;
import com.charniauski.training.horsesrace.datamodel.annotation.EnumType;
import com.charniauski.training.horsesrace.datamodel.enums.Status;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Created by ivc4 on 13.10.2016.
 */
@Entity(tableName = "account", autoincrementColumn = "id")
public class Account extends AbstractModel {

    @Column(columnName = "login")
    private String login;

    @Column(columnName = "password")
    private String password;

    @Column(columnName = "data_register_account")
    private Date dateRegisterAccount;

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

    public Date getDateRegisterAccount() {
        return dateRegisterAccount;
    }

    public void setDateRegisterAccount(Date dateRegisterAccount) {
        this.dateRegisterAccount = dateRegisterAccount;
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

    public Account(String login, String password, Date dateRegisterAccount, Status status, Double balance, String email) {
        this.login = login;
        this.password = password;
        this.dateRegisterAccount = dateRegisterAccount;
        this.status = status;
        this.balance = balance;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + getId() +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", dateRegisterAccount='" + dateRegisterAccount + '\'' +
                ", status=" + status +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o.getClass() != getClass()) return false;
        Account account = (Account) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getId(),account.getId())
                .append(login, account.login)
                .append(password, account.password)
                .append(dateRegisterAccount, account.dateRegisterAccount)
                .append(status, account.status)
                .append(balance, account.balance)
                .append(email, account.email).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(login)
                .append(password)
                .append(dateRegisterAccount)
                .append(status)
                .append(balance)
                .append(email).hashCode();
    }

}
