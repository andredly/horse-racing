package com.charniauski.training.horsesrace.web.dto.dtoi18n;

public class HorseI18nDTO {

    private Long id;

    private String nickName;

    private Integer age;

    private Integer equipmentWeight;

    private String form;

    private String owner;

//    private Command command;

    public HorseI18nDTO() {
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
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", equipmentWeight=" + equipmentWeight +
                ", form='" + form + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

}
