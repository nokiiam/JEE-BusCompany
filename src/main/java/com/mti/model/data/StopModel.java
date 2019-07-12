package com.mti.model.data;


import javax.persistence.Entity;

@Entity
public class StopModel extends Model {

    private String name;

    public StopModel() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
