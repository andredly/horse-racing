package com.charniauski.training.horsesrace.web.dto;

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


    private String form;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HorseDTO horseDTO = (HorseDTO) o;

        if (id != null ? !id.equals(horseDTO.id) : horseDTO.id != null) return false;
        if (nickName != null ? !nickName.equals(horseDTO.nickName) : horseDTO.nickName != null) return false;
        if (age != null ? !age.equals(horseDTO.age) : horseDTO.age != null) return false;
        if (equipmentWeight != null ? !equipmentWeight.equals(horseDTO.equipmentWeight) : horseDTO.equipmentWeight != null)
            return false;
        if (form != null ? !form.equals(horseDTO.form) : horseDTO.form != null) return false;
        return owner != null ? owner.equals(horseDTO.owner) : horseDTO.owner == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (equipmentWeight != null ? equipmentWeight.hashCode() : 0);
        result = 31 * result + (form != null ? form.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }
}
