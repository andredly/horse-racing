package com.charniauski.training.horsesrace.datamodel;

@Entity(tableName = "horse", autoincrementColumn = "id")
public class Horse extends AbstractModel {

    @Column(columnName = "nick_name")
    private String nickName;
    @Column(columnName = "age")
    private Integer age;
    @Column(columnName = "equipment_weight")
    private Integer equipmentWeight;
    @Column(columnName = "form")
    private String form;
    @Column(columnName = "command_id")
    private Long commandId;
    @Column(columnName = "owner")
    private String owner;

//    private Command command;

    public Horse() {
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getEquipmentWeight() {
        return equipmentWeight;
    }

    public void setEquipmentWeight(Integer equipmentWeight) {
        this.equipmentWeight = equipmentWeight;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Long getCommandId() {
        return commandId;
    }

    public void setCommandId(Long commandId) {
        this.commandId = commandId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "id='" + getId() + '\'' +
                "nickName='" + nickName + '\'' +
                ", age=" + age +
                ", equipmentWeight=" + equipmentWeight +
                ", form='" + form + '\'' +
                ", commandId=" + commandId +
                ", owner='" + owner + '\'' +
                '}';
    }
}
