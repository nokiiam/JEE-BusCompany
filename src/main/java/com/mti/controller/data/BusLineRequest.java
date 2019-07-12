package com.mti.controller.data;

public class BusLineRequest extends Request {
    private Integer line_number;

    public BusLineRequest() {
    }

    public Integer getLine_number() {
        return line_number;
    }

    public void setLine_number(Integer line_number) {
        this.line_number = line_number;
    }
}
