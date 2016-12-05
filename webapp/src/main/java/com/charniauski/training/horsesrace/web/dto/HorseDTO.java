package com.charniauski.training.horsesrace.web.dto;

import com.charniauski.training.horsesrace.web.anotation.I18n;
import com.charniauski.training.horsesrace.web.anotation.Language;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HorseDTO {

  private Long id;

    @NotBlank
    @Size(min = 2,max = 18)
    private String nickName;

    @NotNull
    @Min(1)
    private Integer age;

    @NotNull
    @Min(0)
    private Integer equipmentWeight;

    @I18n
    private String formEn;

    @I18n(language = Language.RU)
    private String formRu;

    @NotBlank
    private String owner;

//    private Command command;

    public HorseDTO() {
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

    public String getFormEn() {
        return formEn;
    }

    public void setFormEn(String formEn) {
        this.formEn = formEn;
    }

    public String getFormRu() {
        return formRu;
    }

    public void setFormRu(String formRu) {
        this.formRu = formRu;
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
                ", formRu='" + formRu + '\'' +
                ", formEn='" + formEn + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

}
