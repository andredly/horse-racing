package com.charniauski.training.horsesrace.datamodel;


import com.charniauski.training.horsesrace.datamodel.annotation.Column;

public abstract class AbstractModel {

    @Column(columnName = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
