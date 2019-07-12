package com.mti.controller.converter;

import com.mti.service.data.Entity;

public interface ControllerEntityConverter<REQUEST_MODEL_TYPE, RESPONSE_MODEL_TYPE, ENTITY_TYPE extends Entity> {

    ENTITY_TYPE controllerToEntity(REQUEST_MODEL_TYPE model);

    RESPONSE_MODEL_TYPE entityToController(ENTITY_TYPE entity);
}