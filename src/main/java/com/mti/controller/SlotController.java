package com.mti.controller;

import com.mti.controller.converter.ControllerEntityConverter;
import com.mti.controller.converter.SlotControllerEntityConverter;
import com.mti.controller.data.SlotRequest;
import com.mti.controller.data.SlotResponse;
import com.mti.model.dao.SlotDao;
import com.mti.model.data.SlotModel;
import com.mti.service.SlotService;
import com.mti.service.data.SlotEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


/**
 * Controller for lines
 * Handles requests to '/slots'
 */
@RequestScoped
@Path("/slots")
public class SlotController implements Controller<SlotRequest, SlotResponse, SlotEntity, SlotModel, SlotDao, SlotService> {

    @Inject
    private SlotService service;
    @Inject
    private SlotControllerEntityConverter converter;

    @Override
    public SlotService getService() {
        return service;
    }

    @Override
    public ControllerEntityConverter<SlotRequest, SlotResponse, SlotEntity> getConverter() {
        return converter;
    }

    @Override
    public Response update(int id, SlotRequest request) {
        return Response
                .status(405).build();
    }
}
