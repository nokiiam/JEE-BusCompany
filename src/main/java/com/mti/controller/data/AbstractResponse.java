package com.mti.controller.data;

public abstract class AbstractResponse {

    private Integer id;

    AbstractResponse() {
    }

    public AbstractResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
