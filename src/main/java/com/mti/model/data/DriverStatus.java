package com.mti.model.data;

public enum DriverStatus {
    InActivity,
    DailyRest,
    WeeklyRest;

    public static DriverStatus fromInteger(int x) {
        switch (x) {
            case 0:
                return InActivity;
            case 1:
                return DailyRest;
            case 2:
                return WeeklyRest;
            default:
                return null;
        }
    }
}
