package com.mti.controller.converter;

import com.mti.controller.data.StopRequest;
import com.mti.controller.data.StopResponse;
import com.mti.service.data.StopEntity;

public class ControllerEntityStopConverter implements ControllerEntityConverter<StopRequest, StopResponse, StopEntity> {
    @Override
    public StopEntity controllerToEntity(StopRequest request) {
        StopEntity stopEntity = new StopEntity();
        stopEntity.setId(request.getId());
        stopEntity.setName(request.getName());
        return stopEntity;
    }

    @Override
    public StopResponse entityToController(StopEntity entity) {
        StopResponse stopResponse = new StopResponse();
        stopResponse.setId(entity.getId());
        stopResponse.setName(entity.getName());
        return stopResponse;
    }
}
