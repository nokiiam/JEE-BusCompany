package com.mti.controller.converter;

public interface ControllerEntityConverter<REQUEST_MODEL_TYPE, RESPONSE_MODEL_TYPE, ENTITY_TYPE> {

    ENTITY_TYPE eontrollerToEntity(REQUEST_MODEL_TYPE model);

    RESPONSE_MODEL_TYPE entityToController(ENTITY_TYPE entity);
}