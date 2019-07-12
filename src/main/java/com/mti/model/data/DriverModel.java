package com.mti.model.data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "driver")
public class DriverModel extends Model {
    @Column(name = "code", length = 6, unique = true, nullable = false)
    private String code;

    @Column(name = "birth_date", nullable = false)

    private Date birthDate;

    @Column(name = "firstname", length = 45, nullable = false)
    @Size(min = 2)
    private String firstname;

    @Column(name = "lastname", length = 45, nullable = false)
    @Size(min = 2)
    private String lastname;

    @Column(name = "status", length = 11, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private DriverStatus status;

    @OneToMany(mappedBy = "driver")
    private Set<SlotModel> slots = new HashSet<>();

    @OneToOne(mappedBy = "driver")
    private UserModel user;

    public DriverModel() {
    }

    public DriverModel(String code, Date birthDate, String firstname, String lastname, DriverStatus status) {
        this.code = code;
        this.birthDate = birthDate;
        this.firstname = firstname;
        this.lastname = lastname;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        user.setDriver(this);
        this.user = user;
    }

    public Set<SlotModel> getSlots() {
        return slots;
    }

    public void addSlot(SlotModel slot) {
        if (slot == null)
            return;

        slot.setDriver(this);
        slots.add(slot);
    }

    public void removeSlot(SlotModel slot) {
        slots.remove(slot);
    }
}
