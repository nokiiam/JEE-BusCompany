package com.mti.service.data;

import java.util.Date;

public class SlotEntity extends Entity {

    private Date date;
    private Boolean isMorning;
    private DriverEntity driver;
    private BusEntity bus;
    private LineEntity line;

    public SlotEntity() {
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

    public DriverEntity getDriver() {
        return driver;
    }

    public void setDriver(DriverEntity driver) {
        this.driver = driver;
    }

    public BusEntity getBus() {
        return bus;
    }

    public void setBus(BusEntity bus) {
        this.bus = bus;
    }

    public LineEntity getLine() {
        return line;
    }

    public void setLine(LineEntity line) {
        this.line = line;
    }
}
