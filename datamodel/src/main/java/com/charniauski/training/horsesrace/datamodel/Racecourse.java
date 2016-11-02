package com.charniauski.training.horsesrace.datamodel;

import com.charniauski.training.horsesrace.datamodel.annotation.Column;
import com.charniauski.training.horsesrace.datamodel.annotation.Entity;

/**
 * Created by ivc4 on 19.10.2016.
 */
@Entity(tableName = "racecourse", autoincrementColumn = "id")
public class Racecourse  extends AbstractModel{

    @Column(columnName = "name")
    private String name;

    @Column(columnName = "country")
    private String country;

//    private List<Racecourse> racecourses;


    public Racecourse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Racecourse{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Racecourse that = (Racecourse) o;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return country != null ? country.equals(that.country) : that.country == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
