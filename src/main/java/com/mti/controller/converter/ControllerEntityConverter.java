package com.mti.controller.converter;

import com.mti.controller.data.AbstractRequest;
import com.mti.controller.data.AbstractResponse;
import com.mti.service.data.Entity;

public interface ControllerEntityConverter<REQUEST_TYPE extends AbstractRequest, RESPONSE_TYPE extends AbstractResponse, ENTITY_TYPE extends Entity> {

    ENTITY_TYPE controllerToEntity(REQUEST_TYPE request);

    RESPONSE_TYPE entityToController(ENTITY_TYPE entity);
}