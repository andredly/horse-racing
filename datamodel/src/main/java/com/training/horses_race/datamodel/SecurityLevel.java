package com.training.horses_race.datamodel;

public class SecurityLevel extends AbstractModel{
    private Integer securityLevel;
    private String userStatus;

    public SecurityLevel() {
    }

    public Integer getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(Integer securityLevel) {
        this.securityLevel = securityLevel;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
