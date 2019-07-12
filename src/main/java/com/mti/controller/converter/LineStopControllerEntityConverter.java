package com.mti.controller.converter;

import com.mti.controller.data.LineStopRequest;
import com.mti.controller.data.LineStopResponse;
import com.mti.service.data.LineEntity;
import com.mti.service.data.LineStopEntity;
import com.mti.service.data.StopEntity;

import javax.inject.Inject;

public class LineStopControllerEntityConverter implements ControllerEntityConverter<LineStopRequest, LineStopResponse, LineStopEntity>{

    @Inject
    StopControllerEntityConverter stopController;

    @Inject
    LineControllerEntityConverter lineController;

    @Override
    public LineStopEntity controllerToEntity(LineStopRequest request) {
        LineStopEntity lineStopEntity = new LineStopEntity();

        lineStopEntity.setOrder(request.getOrder());

        StopEntity stop = new StopEntity();
        stop.setId(request.getStop());
        lineStopEntity.setStop(stop);

        LineEntity line = new LineEntity();
        line.setId(request.getLine());
        lineStopEntity.setLine(line);

        return lineStopEntity;
    }

    @Override
    public LineStopResponse entityToController(LineStopEntity entity) {
        LineStopResponse lineStopResponse = new LineStopResponse();

        lineStopResponse.setOrder(entity.getOrder());
        lineStopResponse.setStop(stopController.entityToController(entity.getStop()));
        lineStopResponse.setLine(lineController.entityToController(entity.getLine()));
        lineStopResponse.setId(entity.getId());

        return lineStopResponse;
    }

}
