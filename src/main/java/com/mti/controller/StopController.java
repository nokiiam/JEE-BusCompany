package com.mti.controller;

import com.mti.controller.converter.ControllerEntityConverter;
import com.mti.controller.converter.StopControllerEntityConverter;
import com.mti.controller.data.StopRequest;
import com.mti.controller.data.StopResponse;
import com.mti.model.dao.StopDao;
import com.mti.model.data.StopModel;
import com.mti.service.StopService;
import com.mti.service.data.StopEntity;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 * Controller for lines
 * Handles requests to '/stops'
 */
@Singleton
@Path("/stops")
@Named
public class StopController implements Controller<StopRequest, StopResponse, StopEntity, StopModel, StopDao, StopService> {

    private Integer id = -1;

    private String name;

    @Inject
    private StopService service;
    @Inject
    private StopControllerEntityConverter converter;

    @Override
    public StopService getService() {
        return service;
    }

    @Override
    public ControllerEntityConverter<StopRequest, StopResponse, StopEntity> getConverter() {
        return converter;
    }

    public Response formCreate() {
        StopRequest stopRequest = new StopRequest();
        stopRequest.setName(name);
        return create(stopRequest);
    }

    public void setUpdate(StopResponse stop) {
        id = stop.getId();
        name = stop.getName();
    }

    public Response formUpdate() {
        StopRequest stopRequest = new StopRequest();
        stopRequest.setName(name);
        return update(id, stopRequest);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
