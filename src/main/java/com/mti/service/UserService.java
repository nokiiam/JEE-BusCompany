package com.mti.service;

import com.mti.model.dao.UserDao;
import com.mti.model.data.UserModel;
import com.mti.service.convertor.UserEntityModelConverter;
import com.mti.service.data.UserEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserService extends Service<UserEntity, UserModel, UserDao> {

    @Inject
    public UserService(UserDao dao, UserEntityModelConverter converter) {
        super(dao, converter);
    }
}
