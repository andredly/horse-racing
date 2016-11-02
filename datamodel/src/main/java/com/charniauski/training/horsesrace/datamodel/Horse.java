package com.charniauski.training.horsesrace.datamodel;

import com.charniauski.training.horsesrace.datamodel.annotation.Column;
import com.charniauski.training.horsesrace.datamodel.annotation.Entity;

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "id=" + getId() +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", equipmentWeight=" + equipmentWeight +
                ", form='" + form + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Horse horse = (Horse) o;
        if (getId() != null ? !getId().equals(horse.getId()) : horse.getId() != null) return false;
        if (nickName != null ? !nickName.equals(horse.nickName) : horse.nickName != null) return false;
        if (age != null ? !age.equals(horse.age) : horse.age != null) return false;
        if (equipmentWeight != null ? !equipmentWeight.equals(horse.equipmentWeight) : horse.equipmentWeight != null)
            return false;
        if (form != null ? !form.equals(horse.form) : horse.form != null) return false;
        return owner != null ? owner.equals(horse.owner) : horse.owner == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (equipmentWeight != null ? equipmentWeight.hashCode() : 0);
        result = 31 * result + (form != null ? form.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }
}
