package com.mti.service.convertor;

public interface EntityModelConverter<ENTITY_TYPE, MODEL_TYPE> {
    MODEL_TYPE entityToModel(ENTITY_TYPE entity);

    ENTITY_TYPE modelToEntity(MODEL_TYPE model);
}
