package com.mti.model.dao;

import com.mti.model.data.LineModel;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Singleton
public class LineDao extends Dao<LineModel> {

    @Inject
    LineDao(EntityManager entityManager) {
        super(LineModel.class, entityManager);
    }
}
