package com.mti.service.convertor;

import com.mti.model.data.UserModel;
import com.mti.model.data.UserProfile;
import com.mti.service.data.UserEntity;

import javax.inject.Inject;

public class UserEntityModelConverter implements EntityModelConverter<UserEntity, UserModel> {

    @Inject
    DriverEntityModelConverter driverConverter;

    @Override
    public UserModel entityToModel(UserEntity entity) {
        UserModel userModel = new UserModel();

        userModel.setId(entity.getId());
        userModel.setLogin(entity.getLogin());
        userModel.setPassword(entity.getPassword());
        userModel.setProfile(UserProfile.fromInt(entity.getProfile()));
        if (userModel.getProfile() != null && userModel.getProfile().isConductor()) {
            userModel.setDriver(driverConverter.entityToModel(entity.getDriver()));
        }


        return userModel;
    }

    @Override
    public UserEntity modelToEntity(UserModel model) {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(model.getId());
        userEntity.setProfile(model.getProfile().ordinal());
        userEntity.setPassword(model.getPassword());
        userEntity.setLogin(model.getLogin());
        userEntity.setDriver(driverConverter.modelToEntity(model.getDriver()));

        return userEntity;
    }
}
