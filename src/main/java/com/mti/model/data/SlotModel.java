package com.mti.model.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "slot")
public class SlotModel extends Model {

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "is_morning", nullable = false)
    private Boolean isMorning;


    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = false)
    private DriverModel driver;

    @ManyToOne
    @JoinColumn(name = "bus_id", referencedColumnName = "id", nullable = false)
    private BusModel bus;

    @ManyToOne
    @JoinColumn(name = "bus_line_id", referencedColumnName = "id", nullable = false)
    private LineModel line;

    public SlotModel() {
    }

    public SlotModel(Date date, Boolean isMorning, DriverModel driver, BusModel bus, LineModel line) {
        this.date = date;
        this.isMorning = isMorning;
        this.driver = driver;
        this.bus = bus;
        this.line = line;
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

    public DriverModel getDriver() {
        return driver;
    }

    public void setDriver(DriverModel driver) {
        this.driver = driver;
    }

    public BusModel getBus() {
        return bus;
    }

    public void setBus(BusModel bus) {
        this.bus = bus;
    }

    public LineModel getLine() {
        return line;
    }

    public void setLine(LineModel line) {
        this.line = line;
    }
}
