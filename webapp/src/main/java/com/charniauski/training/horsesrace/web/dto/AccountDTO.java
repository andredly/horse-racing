package com.charniauski.training.horsesrace.web.dto;

import com.charniauski.training.horsesrace.datamodel.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by ivc4 on 13.10.2016.
 */
public class AccountDTO {

    private Long id;

    @NotBlank
    @Size(min=2, max=30)
    private String login;

    @NotBlank
    @Size(min=6, max=16)
    private String password;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z", timezone="GMT")
    private Date dateRegisterAccount;

    private Status status;

    @Min(0)
    private Double balance;

    @Email
    private String email;

    private Boolean isDelete;

    @NotBlank
    @Size(min=2, max=256)
    private String firstName;

    @NotBlank
    @Size(min=2, max=256)
    private String lastName;

    @Past
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date dateBirth;

    @NotBlank
    @Size(min=2, max=256)
    private String address;

    public AccountDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean delete) {
        isDelete = delete;
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

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Account{" +
                " id=" + id +
                " login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", dateRegisterAccount=" + dateRegisterAccount +
                ", status=" + status +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                ", isDelete=" + isDelete +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date=" + dateBirth +
                ", address='" + address + '\'' +
                '}';
    }

}
