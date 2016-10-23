package com.charniauski.training.horsesrace.datamodel;


public abstract class AbstractModel {

    @Column(columnName = "id",isAutoIncrement = true)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
