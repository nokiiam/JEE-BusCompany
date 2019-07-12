package com.mti.model.dao;

import com.mti.model.data.StopModel;

import javax.inject.Named;

@Named
public class StopDao extends Dao<StopModel> {

    public StopDao() {
        super(StopModel.class);
    }
}
