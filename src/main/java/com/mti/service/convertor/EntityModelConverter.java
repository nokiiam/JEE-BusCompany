package com.mti.service.convertor;

import com.mti.model.data.Model;
import com.mti.service.data.Entity;

public interface EntityModelConverter<ENTITY_TYPE extends Entity, MODEL_TYPE extends Model> {
    /**
     * Transform an entity from the service tier to an equivalent model from the model tier
     *
     * @param entity entity to transform
     * @return model equivalent of the entity
     */
    MODEL_TYPE entityToModel(ENTITY_TYPE entity);

    /**
     * Transform a model from the model tier to an equivalent entity from the service tier
     * @param model model to transform
     * @return entity equivalent of the model
     */
    ENTITY_TYPE modelToEntity(MODEL_TYPE model);
}
