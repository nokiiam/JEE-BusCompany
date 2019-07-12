package com.mti.controller.converter;

import com.mti.controller.data.Request;
import com.mti.controller.data.Response;
import com.mti.service.data.Entity;

public interface ControllerEntityConverter<REQUEST_TYPE extends Request, RESPONSE_TYPE extends Response, ENTITY_TYPE extends Entity> {

    ENTITY_TYPE controllerToEntity(REQUEST_TYPE request);

    RESPONSE_TYPE entityToController(ENTITY_TYPE entity);
}