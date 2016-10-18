package com.charniauski.training.horsesrace.datamodel;

public class SecurityLevel extends AbstractModel{
    private Integer level;
    private String userStatus;

    public SecurityLevel() {
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

}
