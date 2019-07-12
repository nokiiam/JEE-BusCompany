package com.mti.controller.data;

import java.util.Date;

public class SlotResponse extends AbstractResponse {

    private Date date;
    private Boolean isMorning;
    private Integer driver;
    private Integer bus;
    private Integer line;

    public SlotResponse() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getMorning() {
        return isMorning;
    }

    public void setMorning(Boolean morning) {
        isMorning = morning;
    }

    public Integer getDriver() {
        return driver;
    }

    public void setDriver(Integer driver) {
        this.driver = driver;
    }

    public Integer getBus() {
        return bus;
    }

    public void setBus(Integer bus) {
        this.bus = bus;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }
}
