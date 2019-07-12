package com.mti.model.dao;

import com.mti.model.data.BusModel;

import javax.inject.Named;

@Named
public class BusDao extends Dao<BusModel> {

    BusDao() {
        super(BusModel.class);
    }
}
