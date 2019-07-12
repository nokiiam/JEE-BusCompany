package com.mti.model.dao;

import com.mti.model.data.LineModel;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;

@Singleton
public class LineDao extends Dao<LineModel> {
    LineDao(EntityManager entityManager) {
        super(LineModel.class, entityManager);
    }
}
