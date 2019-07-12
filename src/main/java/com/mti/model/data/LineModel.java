package com.mti.model.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bus_line")
public class LineModel extends Model {

    @Column(name = "number", length = 11, unique = true, nullable = false)
    private int number;

    @OneToMany(mappedBy = "line")
    private Set<SlotModel> slots = new HashSet<>();

    @OneToMany(mappedBy = "line")
    private Set<LineStopModel> lineStops = new HashSet<>();

    public LineModel() {
    }

    public LineModel(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Set<SlotModel> getSlots() {
        return slots;
    }

    public void addSlot(SlotModel slot) {
        if (slot == null)
            return;

        slot.setLine(this);
        if (slots.contains(slot))
            return;
        slots.add(slot);
    }

    public void removeSlot(SlotModel slot) {
        slots.remove(slot);
    }

    public void addSlots(SlotModel slot) {
        if (slot == null)
            return;

        slot.setLine(this);
        slots.add(slot);
    }

    public Set<LineStopModel> getLineStops() {
        return lineStops;
    }

    public void addLineStop(LineStopModel lineStop) {
        if (lineStop == null)
            return;

        lineStop.setLine(this);
        lineStops.add(lineStop);
    }
}
