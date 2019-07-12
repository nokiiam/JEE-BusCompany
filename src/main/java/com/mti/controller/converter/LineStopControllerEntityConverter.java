package com.mti.controller.converter;

import com.mti.controller.data.LineStopRequest;
import com.mti.controller.data.LineStopResponse;
import com.mti.service.LineService;
import com.mti.service.StopService;
import com.mti.service.data.LineEntity;
import com.mti.service.data.LineStopEntity;
import com.mti.service.data.StopEntity;

import javax.inject.Inject;

public class LineStopControllerEntityConverter implements ControllerEntityConverter<LineStopRequest, LineStopResponse, LineStopEntity>{

    @Inject
    StopService stopService;

    @Inject
    LineService lineService;

    @Override
    public LineStopEntity controllerToEntity(LineStopRequest request) {
        StopEntity stopEntity = stopService.getById(request.getStop());
        if (stopEntity == null)
            return null;

        LineEntity lineEntity = lineService.getById(request.getLine());
        if (lineEntity == null)
            return null;

        LineStopEntity lineStopEntity = new LineStopEntity();
        lineStopEntity.setOrder(request.getOrder());
        lineStopEntity.setStop(stopEntity);
        lineStopEntity.setLine(lineEntity);

        return lineStopEntity;
    }

    @Override
    public LineStopResponse entityToController(LineStopEntity entity) {
        LineStopResponse lineStopResponse = new LineStopResponse();

        lineStopResponse.setLine(entity.getLine().getId());
        lineStopResponse.setOrder(entity.getOrder());
        lineStopResponse.setStop(entity.getStop().getId());
        lineStopResponse.setId(entity.getId());

        return lineStopResponse;
    }

}
