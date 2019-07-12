package com.mti.controller;

import com.mti.controller.converter.ControllerEntityConverter;
import com.mti.controller.converter.LineStopControllerEntityConverter;
import com.mti.controller.data.LineStopRequest;
import com.mti.controller.data.LineStopResponse;
import com.mti.model.dao.LineStopDao;
import com.mti.model.data.LineStopModel;
import com.mti.service.LineStopService;
import com.mti.service.data.LineStopEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;


/**
 * Controller for lines
 * Handles requests to '/linestops'
 */
@RequestScoped
@Path("/linestops")
public class LineStopController implements Controller<LineStopRequest, LineStopResponse, LineStopEntity, LineStopModel, LineStopDao, LineStopService> {

    @Inject
    private LineStopService service;
    @Inject
    private LineStopControllerEntityConverter converter;

    @Override
    public LineStopService getService() {
        return service;
    }

    @Override
    public ControllerEntityConverter<LineStopRequest, LineStopResponse, LineStopEntity> getConverter() {
        return converter;
    }
}
