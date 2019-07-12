package com.mti.controller.converter;

import com.mti.service.data.Entity;
import com.mti.controller.data.Request;
import com.mti.controller.data.Response;

public interface ControllerEntityConverter<REQUEST_MODEL_TYPE extends Request, RESPONSE_MODEL_TYPE extends Response, ENTITY_TYPE extends Entity> {

    ENTITY_TYPE controllerToEntity(REQUEST_MODEL_TYPE model);

    RESPONSE_MODEL_TYPE entityToController(ENTITY_TYPE entity);
}