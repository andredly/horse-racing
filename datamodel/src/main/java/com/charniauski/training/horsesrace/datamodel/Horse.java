package com.charniauski.training.horsesrace.datamodel;

@Entity(tableName = "horse", autoincrementColumn = "id")
public class Horse extends AbstractModel {
    @Column(columnName = "id",isAutoIncrement = true)
    private Long id;

    @Column(columnName = "nick_name")
    private String nickName;
    @Column(columnName = "age")
    private Integer age;
    @Column(columnName = "equipment_weight")
    private Integer equipmentWeight;
    @Column(columnName = "form")
    private String form;
    @Column(columnName = "owner")
    private String owner;

//    private Command command;

    public Horse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                ", owner='" + owner + '\'' +
                '}';
    }
}
