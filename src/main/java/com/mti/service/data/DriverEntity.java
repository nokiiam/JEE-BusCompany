package com.mti.service.data;

import java.util.Date;

public class DriverEntity extends Entity {

    /**
     * The driver code of the driver, constituted most of the time by the first 4 letters of the last name and the first
     * 2 letters of the firstname.
     */
    private String code;

    /**
     * The driver's status e.g. if he's working, or at rest, and if he's resting for the day or for the week.
     */
    private Integer status;
    private Date birthDate;
    private String firstname;
    private String lastname;

    public DriverEntity() {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
