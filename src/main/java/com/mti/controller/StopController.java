package com.mti.controller;

import com.mti.controller.converter.ControllerEntityConverter;
import com.mti.controller.converter.StopControllerEntityConverter;
import com.mti.controller.data.StopRequest;
import com.mti.controller.data.StopResponse;
import com.mti.model.dao.StopDao;
import com.mti.model.data.StopModel;
import com.mti.service.StopService;
import com.mti.service.data.StopEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class StopController implements Controller<StopRequest, StopResponse, StopEntity, StopModel, StopDao, StopService> {

    @Inject
    private StopService service;
    @Inject
    private StopControllerEntityConverter converter;

    @Override
    public StopService getService() {
        return null;
    }

    @Override
    public ControllerEntityConverter<StopRequest, StopResponse, StopEntity> getConverter() {
        return null;
    }
}
