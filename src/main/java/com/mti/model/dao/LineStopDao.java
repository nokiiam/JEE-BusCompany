package com.mti.model.dao;

import com.mti.model.data.LineStopModel;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class LineStopDao extends Dao<LineStopModel> {

    @Inject
    LineStopDao(EntityManager entityManager) {
        super(LineStopModel.class, entityManager);
    }
}
