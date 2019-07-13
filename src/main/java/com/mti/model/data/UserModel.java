package com.mti.model.data;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserModel extends Model {

    @Column(name = "login", nullable = false, unique = true, length = 11)
    private String login;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private DriverModel driver;

    @Column(name = "profile", nullable = false, length = 11)
    @Enumerated(EnumType.ORDINAL)
    private UserProfile profile;

    public UserModel() {
    }

    public UserModel(String login, String password, DriverModel driver, UserProfile profile) {
        this.login = login;
        this.password = password;
        this.driver = driver;
        this.profile = profile;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DriverModel getDriver() {
        return driver;
    }

    public void setDriver(DriverModel driver) {
        this.driver = driver;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }
}
