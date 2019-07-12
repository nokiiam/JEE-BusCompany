package com.mti.controller;

import com.mti.controller.converter.ControllerEntityConverter;
import com.mti.controller.converter.LineControllerEntityConverter;
import com.mti.controller.data.LineRequest;
import com.mti.controller.data.LineResponse;
import com.mti.model.dao.LineDao;
import com.mti.model.data.LineModel;
import com.mti.service.LineService;
import com.mti.service.data.LineEntity;

import javax.inject.Inject;

public class LineController implements Controller<LineRequest, LineResponse, LineEntity, LineModel, LineDao, LineService> {

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
}
