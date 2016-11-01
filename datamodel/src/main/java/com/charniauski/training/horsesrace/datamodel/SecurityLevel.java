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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecurityLevel that = (SecurityLevel) o;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return clientStatus != null ? clientStatus.equals(that.clientStatus) : that.clientStatus == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        return 31 * result + (clientStatus != null ? clientStatus.hashCode() : 0);
    }
}
