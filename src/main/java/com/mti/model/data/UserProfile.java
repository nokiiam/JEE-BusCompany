package com.mti.model.data;

public enum UserProfile {
    None,
    Administrator,
    Conductor,
    AdministratorAndConductor;

    static public UserProfile fromInt(Integer x) {
        if (x == null)
            return null;
        switch (x) {
            case 0:
                return None;
            case 1:
                return Administrator;
            case 2:
                return Conductor;
            case 3:
                return AdministratorAndConductor;
            default:
                return null;
        }
    }

    public boolean isAdmin() {
        return (ordinal() & 1) != 0;
    }

    public boolean isConductor() {
        return (ordinal() & 2) != 0;
    }
}
