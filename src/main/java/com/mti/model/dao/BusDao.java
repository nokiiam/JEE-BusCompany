package com.mti.model.dao;

import com.mti.model.data.BusModel;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class BusDao extends Dao<BusModel> {

    @Inject
    BusDao(EntityManager entityManager) {
        super(BusModel.class, entityManager);
    }
}
