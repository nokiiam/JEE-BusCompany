package com.mti.model.data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bus_stop")
public class StopModel extends Model {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public StopModel() {
    }

    public StopModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
