package com.mti.service;

import com.mti.model.dao.DriverDao;
import com.mti.model.dao.UserDao;
import com.mti.model.data.UserModel;
import com.mti.service.convertor.UserEntityModelConverter;
import com.mti.service.data.UserEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserService extends Service<UserEntity, UserModel, UserDao> {

    @Inject
    DriverDao driverDao;

    @Inject
    public UserService(UserDao dao, UserEntityModelConverter converter) {
        super(dao, converter);
    }

    @Override
    public UserEntity create(UserEntity entity) {
        UserModel model = converter.entityToModel(entity);
        if (model.getDriver() != null && model.getDriver().getId() == null && model.getDriver().getCode() != null) {
            model.setDriver(driverDao.getByCode(model.getDriver().getCode()));
        }
        dao.create(model);
        return converter.modelToEntity(model);
    }

    @Override
    public UserEntity update(int id, UserEntity entity) {
        UserModel model = dao.getById(id);
        if (model == null)
            return null;

        model = converter.entityToModel(entity);
        model.setId(id);
        if (model.getDriver() != null && model.getDriver().getId() == null && model.getDriver().getCode() != null) {
            model.setDriver(driverDao.getByCode(model.getDriver().getCode()));
        }
        return converter.modelToEntity(dao.update(model));
    }
}
