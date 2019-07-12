package com.mti.model.dao;

import com.mti.model.data.LineStopModel;

import javax.inject.Named;

@Named
public class LineStopDao extends Dao<LineStopModel> {

    LineStopDao() {
        super(LineStopModel.class);
    }
}
