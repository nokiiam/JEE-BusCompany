package com.mti.controller.converter;

import com.mti.controller.data.LineRequest;
import com.mti.controller.data.LineResponse;
import com.mti.service.data.LineEntity;

public class LineControllerEntityConverter implements ControllerEntityConverter<LineRequest, LineResponse, LineEntity> {
    @Override
    public LineEntity controllerToEntity(LineRequest request) {
        LineEntity stopEntity = new LineEntity();

        stopEntity.setNumber(request.getNumber());
        return stopEntity;
    }

    @Override
    public LineResponse entityToController(LineEntity entity) {
        LineResponse stopResponse = new LineResponse();

        stopResponse.setId(entity.getId());
        stopResponse.setNumber(entity.getNumber());
        return stopResponse;
    }
}
