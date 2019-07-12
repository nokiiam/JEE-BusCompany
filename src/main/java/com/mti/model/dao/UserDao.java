package com.mti.model.dao;

import com.mti.model.data.UserModel;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class UserDao extends Dao<UserModel> {

    @Inject
    UserDao(EntityManager entityManager) {
        super(UserModel.class, entityManager);
    }
}
