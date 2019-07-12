package com.mti.model.dao;

import com.mti.model.data.SlotModel;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class SlotDao extends Dao<SlotModel> {

    @Inject
    SlotDao(EntityManager entityManager) {
        super(SlotModel.class, entityManager);
    }
}
