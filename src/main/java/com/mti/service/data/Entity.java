package com.mti.service.data;

public abstract class Entity {
    private Integer id;

    Entity() {
    }

    Entity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
