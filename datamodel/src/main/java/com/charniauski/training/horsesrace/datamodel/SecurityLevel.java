package com.charniauski.training.horsesrace.datamodel;

@Entity(tableName = "security_level", autoincrementColumn = "id")
public class SecurityLevel extends AbstractModel{

    @Column(columnName = "client_status")
    private String clientStatus;

    public SecurityLevel() {
    }


    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    @Override
    public String toString() {
        return "SecurityLevel{" +
                "id='" + getId() + '\'' +
                ", clientStatus='" + clientStatus + '\'' +
                '}';
    }
}
