package com.mti.controller.converter;

import com.mti.controller.data.DriverRequest;
import com.mti.controller.data.DriverResponse;
import com.mti.service.data.DriverEntity;

public class DriverControllerEntityConverter implements ControllerEntityConverter<DriverRequest, DriverResponse, DriverEntity> {
    @Override
    public DriverEntity controllerToEntity(DriverRequest request) {
        if (request == null)
            return null;
        DriverEntity entity = new DriverEntity();

        entity.setBirthDate(request.getBirthDate());
        entity.setFirstname(request.getFirstname());
        entity.setLastname(request.getLastname());
        entity.setStatus(request.getStatus());
        return entity;
    }

    @Override
    public DriverResponse entityToController(DriverEntity entity) {
        if (entity == null)
            return null;
        DriverResponse response = new DriverResponse();

        response.setId(entity.getId());
        response.setBirthDate(entity.getBirthDate());
        response.setCode(entity.getCode());
        response.setFirstname(entity.getFirstname());
        response.setLastname(entity.getLastname());
        response.setStatus(entity.getStatus());
        return response;
    }
}
