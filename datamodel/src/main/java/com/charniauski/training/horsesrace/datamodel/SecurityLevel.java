package com.charniauski.training.horsesrace.datamodel;

@Entity(tableName = "security_level")
public class SecurityLevel extends AbstractModel{
    @Column(columnName = "id",isAutoIncrement = true)
    private Long id;
    
    @Column(columnName = "client_status")
    private String clientStatus;

    public SecurityLevel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", clientStatus='" + clientStatus + '\'' +
                '}';
    }
}
