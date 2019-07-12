package com.mti.controller.data;

public abstract class Response {

    private Integer id;

    Response() {
    }

    public Response(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
