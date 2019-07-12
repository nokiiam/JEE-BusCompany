package com.mti.model.dao;

import com.mti.model.data.BusLineModel;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;

@Singleton
public class BusLineDao extends Dao {
    BusLineDao(EntityManager entityManager) {
        super(BusLineModel.class, entityManager);
    }
}
