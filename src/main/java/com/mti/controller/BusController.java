package com.mti.controller;

import com.mti.controller.converter.BusControllerEntityConverter;
import com.mti.controller.converter.ControllerEntityConverter;
import com.mti.controller.data.BusRequest;
import com.mti.controller.data.BusResponse;
import com.mti.model.dao.BusDao;
import com.mti.model.data.BusModel;
import com.mti.service.BusService;
import com.mti.service.data.BusEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class BusController implements Controller<BusRequest, BusResponse, BusEntity, BusModel, BusDao, BusService> {

    @Inject
    private BusService service;
    @Inject
    private BusControllerEntityConverter converter;

    @Override
    public BusService getService() {
        return null;
    }

    @Override
    public ControllerEntityConverter<BusRequest, BusResponse, BusEntity> getConverter() {
        return null;
    }
}