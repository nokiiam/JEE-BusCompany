package com.mti.model.dao;

import com.mti.model.data.StopModel;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

@Singleton
public class StopDao extends Dao<StopModel> {

    @Inject
    public StopDao(EntityManager entityManager) {
        super(StopModel.class, entityManager);
    }
}
