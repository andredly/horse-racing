package com.training.horses_race.datamodelmax;


import com.training.horses_race.datamodel.*;
import com.training.horses_race.datamodel.SecurityLevel;

import javax.jws.soap.SOAPBinding;

/**
 * Created by ivc4 on 13.10.2016.
 */
public class Account extends AbstractModel {
    private String login;
    private String password;
    private Double balance;
    private String email;
    private String securityQuestion;
    private String answer;
    private Integer mobileNumber;

//    private User user;
//    private SecurityLevel securityLevel;

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

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
