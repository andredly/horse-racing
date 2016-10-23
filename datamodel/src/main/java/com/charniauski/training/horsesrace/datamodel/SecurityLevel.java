package com.charniauski.training.horsesrace.datamodel;

@Entity(tableName = "security_level")
public class SecurityLevel extends AbstractModel{
    @Column(columnName = "level")
    private Integer level;
    @Column(columnName = "client_status")
    private String clientStatus;

    public SecurityLevel() {
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUserStatus() {
        return clientStatus;
    }

    public void setUserStatus(String userStatus) {
        this.clientStatus = userStatus;
    }

}
