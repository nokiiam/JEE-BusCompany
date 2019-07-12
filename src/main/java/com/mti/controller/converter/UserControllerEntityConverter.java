package com.mti.controller.converter;

import com.mti.controller.data.UserRequest;
import com.mti.controller.data.UserResponse;
import com.mti.service.DriverService;
import com.mti.service.data.DriverEntity;
import com.mti.service.data.UserEntity;

import javax.inject.Inject;

public class UserControllerEntityConverter implements ControllerEntityConverter<UserRequest, UserResponse, UserEntity> {

    @Inject
    DriverService driverService;

    @Override
    public UserEntity controllerToEntity(UserRequest request) {
        DriverEntity driverEntity = driverService.getById(request.getDriver());
        if (driverEntity == null)
            return null;

        UserEntity userEntity = new UserEntity();

        userEntity.setLogin(request.getLogin());
        userEntity.setPassword(request.getPassword());
        userEntity.setProfile(request.getProfile());
        userEntity.setDriver(driverEntity);

        return userEntity;
    }

    @Override
    public UserResponse entityToController(UserEntity entity) {
        UserResponse userResponse = new UserResponse();

        userResponse.setId(entity.getId());
        userResponse.setLogin(entity.getLogin());
        userResponse.setPassword(entity.getPassword());
        userResponse.setProfile(entity.getProfile());
        userResponse.setDriver(entity.getDriver().getId());

        return userResponse;
    }
}
