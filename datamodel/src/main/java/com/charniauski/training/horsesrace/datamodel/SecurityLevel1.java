package com.charniauski.training.horsesrace.datamodel;

@Entity(tableName = "security_l")
public class SecurityLevel1 extends AbstractModel{

    @Column(columnName = "security_level")
    private AccountStatus1 securityLevel;

    public SecurityLevel1() {
    }

    public AccountStatus1 getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(AccountStatus1 securityLevel) {
        this.securityLevel = securityLevel;
    }

    public enum AccountStatus1 {
        ADMIN, BOOKMAKER, CLIENT
    }

    @Override
    public String toString() {
        return "SecurityLevel1{" +
                "id="+getId()+
                ", securityLevel=" + securityLevel +
                '}';
    }
}
