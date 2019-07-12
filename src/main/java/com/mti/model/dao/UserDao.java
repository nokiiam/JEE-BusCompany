package com.mti.model.dao;

import com.mti.model.data.UserModel;

import javax.inject.Named;

@Named
public class UserDao extends Dao<UserModel> {

    UserDao() {
        super(UserModel.class);
    }
}
