package com.mti.controller.data;

import java.util.Date;

public class SlotResponse extends AbstractResponse {

    private Date date;
    private Boolean isMorning;
    private DriverResponse driver;
    private BusResponse bus;
    private LineResponse line;

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

    public DriverResponse getDriver() {
        return driver;
    }

    public void setDriver(DriverResponse driver) {
        this.driver = driver;
    }

    public BusResponse getBus() {
        return bus;
    }

    public void setBus(BusResponse bus) {
        this.bus = bus;
    }

    public LineResponse getLine() {
        return line;
    }

    public void setLine(LineResponse line) {
        this.line = line;
    }
}
