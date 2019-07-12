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

    public static int ToInteger(DriverStatus status) {
        switch (status) {
            case DailyRest:
                return 1;
            case InActivity:
                return 0;
            case WeeklyRest:
                return 2;
            default:
                return -1;
        }
    }

    public int toInteger() {
        return DriverStatus.ToInteger(this);
    }
}
