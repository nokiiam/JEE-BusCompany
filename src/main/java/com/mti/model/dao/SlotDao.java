package com.mti.model.dao;

import com.mti.model.data.SlotModel;

import javax.inject.Named;


@Named
public class SlotDao extends Dao<SlotModel> {

    SlotDao() {
        super(SlotModel.class);
    }
}
