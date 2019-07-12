package com.mti.controller.converter;

import com.mti.controller.data.StopRequest;
import com.mti.controller.data.StopResponse;
import com.mti.service.data.StopEntity;

public class ControllerEntityStopConverter implements ControllerEntityConverter<StopRequest, StopResponse, StopEntity> {
    @Override
    public StopEntity controllerToEntity(StopRequest model) {
        return null;
    }

    @Override
    public StopResponse entityToController(StopEntity entity) {
        return null;
    }
}
