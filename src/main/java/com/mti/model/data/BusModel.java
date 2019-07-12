package com.mti.model.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bus")
public class BusModel extends Model {

    @Column(name = "registration", nullable = false, unique = true, length = 9)
    private String registration;

    @Column(name = "brand", nullable = false, length = 45)
    private String Brand;

    @Column(name = "capacity", length = 11, nullable = false)
    private int capacity;

    @Column(name = "release_year", nullable = false)
    private Date releaseYear;

    @Column(name = "kilometers", length = 11, nullable = false)
    private int kilometers;

    @OneToMany(mappedBy = "bus")
    private Set<SlotModel> slots = new HashSet<>();

    public BusModel() {
    }

    public BusModel(String registration, String brand, int capacity, Date releaseYear, int kilometers) {
        this.registration = registration;
        Brand = brand;
        this.capacity = capacity;
        this.releaseYear = releaseYear;
        this.kilometers = kilometers;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public Set<SlotModel> getSlots() {
        return slots;
    }

    public void addSlot(SlotModel slot) {
        if (slot == null)
            return;

        slot.setBus(this);
        slots.add(slot);
    }

    public void removeSlot(SlotModel slot) {
        slots.remove(slot);
    }
}
