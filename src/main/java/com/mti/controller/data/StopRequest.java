package com.mti.controller.data;

import javax.inject.Named;

@Named
public class StopRequest extends AbstractRequest {
    private String name;

    public StopRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
