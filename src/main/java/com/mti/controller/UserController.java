package com.mti.controller;

import com.mti.controller.converter.ControllerEntityConverter;
import com.mti.controller.converter.UserControllerEntityConverter;
import com.mti.controller.data.UserRequest;
import com.mti.controller.data.UserResponse;
import com.mti.model.dao.UserDao;
import com.mti.model.data.UserModel;
import com.mti.service.UserService;
import com.mti.service.data.UserEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;


/**
 * Controller for lines
 * Handles requests to '/users'
 */
@RequestScoped
@Path("/users")
public class UserController implements Controller<UserRequest, UserResponse, UserEntity, UserModel, UserDao, UserService> {

    @Inject
    private UserService service;
    @Inject
    private UserControllerEntityConverter converter;

    @Override
    public UserService getService() {
        return service;
    }

    @Override
    public ControllerEntityConverter<UserRequest, UserResponse, UserEntity> getConverter() {
        return converter;
    }
}
