package com.mti.controller.converter;

import com.mti.controller.data.StopRequest;
import com.mti.controller.data.StopResponse;
import com.mti.service.data.StopEntity;

public class StopControllerEntityConverter implements ControllerEntityConverter<StopRequest, StopResponse, StopEntity> {
    @Override
    public StopEntity controllerToEntity(StopRequest request) {
        StopEntity entity = new StopEntity();
        entity.setName(request.getName());
        return entity;
    }

    @Override
    public StopResponse entityToController(StopEntity entity) {
        StopResponse response = new StopResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        return response;
    }
}
