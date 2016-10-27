package com.charniauski.training.horsesrace.datamodel;

/**
 * Created by ivc4 on 13.10.2016.
 */
@Entity(tableName = "account", isIdColumnAutoincrement = false)
public class Account extends AbstractModel{
//    @Column(columnName = "id",isAutoIncrement = false)
//    private Long id;


    @Column(columnName = "login")
    private String login;
    @Column(columnName = "password")
    private String password;
    @Column(columnName = "security_level_id")
    private Long securityLevelId;
    @Column(columnName = "balance")
    private Double balance;
    @Column(columnName = "email")
    private String email;

//    private SecurityLevel securityLevel;
//    private User user;

    public Account() {
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

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

    public Long getSecurityLevelId() {
        return securityLevelId;
    }

    public void setSecurityLevelId(Long securityLevelId) {
        this.securityLevelId = securityLevelId;
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
//                "id='" + id + '\'' +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                '}';
    }
}
