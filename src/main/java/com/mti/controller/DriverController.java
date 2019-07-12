package com.mti.controller;

import com.mti.controller.converter.ControllerEntityConverter;
import com.mti.controller.converter.DriverControllerEntityConverter;
import com.mti.controller.data.DriverRequest;
import com.mti.controller.data.DriverResponse;
import com.mti.model.dao.DriverDao;
import com.mti.model.data.DriverModel;
import com.mti.service.DriverService;
import com.mti.service.data.DriverEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;


/**
 * Controller for lines
 * Handles requests to '/drivers'
 */
@RequestScoped
@Path("/drivers")
public class DriverController implements Controller<DriverRequest, DriverResponse, DriverEntity, DriverModel, DriverDao, DriverService> {

    @Inject
    private DriverService service;
    @Inject
    private DriverControllerEntityConverter converter;

    @Override
    public DriverService getService() {
        return service;
    }

    @Override
    public ControllerEntityConverter<DriverRequest, DriverResponse, DriverEntity> getConverter() {
        return converter;
    }
}
