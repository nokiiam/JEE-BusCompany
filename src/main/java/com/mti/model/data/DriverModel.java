package com.mti.model.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "driver")
public class DriverModel extends Model {
    @Column(name = "code", length = 6, unique = true, nullable = false)
    private String code;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "firstname", length = 45, nullable = false)
    private String firstname;

    @Column(name = "lastname", length = 45, nullable = false)
    private String lastname;

    @Column(name = "status", length = 11, nullable = false)
    private int status;

    public DriverModel() {
    }

    public DriverModel(String code, Date birthDate, String firstname, String lastname, int status) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
