package com.mti.controller;

import com.mti.controller.converter.ControllerEntityConverter;
import com.mti.controller.converter.LineControllerEntityConverter;
import com.mti.controller.data.LineRequest;
import com.mti.controller.data.LineResponse;
import com.mti.model.dao.LineDao;
import com.mti.model.data.LineModel;
import com.mti.service.LineService;
import com.mti.service.data.LineEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 * Controller for lines
 * Handles requests to '/lines'
 */
@RequestScoped
@Path("/lines")
@Named
public class LineController implements Controller<LineRequest, LineResponse, LineEntity, LineModel, LineDao, LineService> {

    private Integer number;

    @Inject
    private LineService service;
    @Inject
    private LineControllerEntityConverter converter;

    @Override
    public LineService getService() {
        return service;
    }

    @Override
    public ControllerEntityConverter<LineRequest, LineResponse, LineEntity> getConverter() {
        return converter;
    }

    public Response formCreate() {
        LineRequest lineRequest = new LineRequest();
        lineRequest.setNumber(number);
        return create(lineRequest);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
