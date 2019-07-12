package com.mti.service.convertor;

import com.mti.model.data.Model;
import com.mti.service.data.Entity;

public interface EntityModelConverter<ENTITY_TYPE extends Entity, MODEL_TYPE extends Model> {
    MODEL_TYPE entityToModel(ENTITY_TYPE entity);

    ENTITY_TYPE modelToEntity(MODEL_TYPE model);
}
