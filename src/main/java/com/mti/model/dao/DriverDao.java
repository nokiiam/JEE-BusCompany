package com.mti.model.dao;

import com.mti.model.data.DriverModel;

import javax.inject.Named;

@Named
public class DriverDao extends Dao<DriverModel> {

    DriverDao() {
        super(DriverModel.class);
    }
}
