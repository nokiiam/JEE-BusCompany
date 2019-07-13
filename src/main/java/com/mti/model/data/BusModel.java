package com.mti.model.data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bus")
public class BusModel extends Model {

    @Column(name = "registration", nullable = false, unique = true, length = 9)
    @Pattern(regexp = "[A-Z]{2}-[0-9]{3}-[A-Z]{2}")
    private String registration;

    @Column(name = "brand", nullable = false, length = 45)
    @Enumerated(EnumType.STRING)
    private BusBrand Brand;

    @Column(name = "capacity", length = 11, nullable = false)
    @Min(20)
    @Max(80)
    private Integer capacity;

    @Column(name = "release_year", nullable = false)
    private Date releaseYear;

    @Column(name = "kilometers", length = 11, nullable = false)
    @Min(0)
    private Integer kilometers;

    @OneToMany(mappedBy = "bus")
    private Set<SlotModel> slots = new HashSet<>();

    public BusModel() {
    }

    public BusModel(String registration, BusBrand brand, Integer capacity, Date releaseYear, Integer kilometers) {
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

    public BusBrand getBrand() {
        return Brand;
    }

    public void setBrand(BusBrand brand) {
        Brand = brand;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
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
