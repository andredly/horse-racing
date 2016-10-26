package com.charniauski.training.horsesrace.datamodel;

/**
 * Created by ivc4 on 19.10.2016.
 */
@Entity(tableName = "racecourse")
public class Racecourse  extends AbstractModel{
    @Column(columnName = "id",isAutoIncrement = true)
    private Long id;

    @Column(columnName = "name")
    private String name;
    @Column(columnName = "country")
    private String country;

//    private List<Racecourse> racecourses;


    public Racecourse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
