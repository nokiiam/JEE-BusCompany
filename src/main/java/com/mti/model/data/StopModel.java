package com.mti.model.data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bus_stop")
public class StopModel extends Model {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "stop")
    private Set<LineStopModel> lineStops = new HashSet<>();

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

    public Set<LineStopModel> getLineStops() {
        return lineStops;
    }

    public void addLineStops(LineStopModel lineStop) {
        if (lineStop == null)
            return;

        lineStop.setStop(this);
        lineStops.add(lineStop);
    }
}
