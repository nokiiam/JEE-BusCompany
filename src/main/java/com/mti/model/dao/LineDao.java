package com.mti.model.dao;

import com.mti.model.data.LineModel;

import javax.inject.Named;

@Named
public class LineDao extends Dao<LineModel> {

    LineDao() {
        super(LineModel.class);
    }
}
