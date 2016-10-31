package com.charniauski.training.horsesrace.datamodel;

/**
 * Created by ivc4 on 13.10.2016.
 */
@Entity(tableName = "account", autoincrementColumn = "id")
public class Account extends AbstractModel{

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
                "id='" + getId() + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (login != null ? !login.equals(account.login) : account.login != null) return false;
        if (password != null ? !password.equals(account.password) : account.password != null) return false;
        if (securityLevelId != null ? !securityLevelId.equals(account.securityLevelId) : account.securityLevelId != null)
            return false;
        if (balance != null ? !balance.equals(account.balance) : account.balance != null) return false;
        return email != null ? email.equals(account.email) : account.email == null;

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (securityLevelId != null ? securityLevelId.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
