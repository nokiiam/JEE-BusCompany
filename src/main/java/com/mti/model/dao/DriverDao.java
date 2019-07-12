package com.mti.model.dao;

import com.mti.model.data.DriverModel;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class DriverDao extends Dao<DriverModel> {

    @Inject
    DriverDao(EntityManager entityManager) {
        super(DriverModel.class, entityManager);
    }
}
