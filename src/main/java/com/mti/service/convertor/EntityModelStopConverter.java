package com.mti.service.convertor;

import com.mti.model.data.StopModel;
import com.mti.service.data.StopEntity;

import javax.inject.Singleton;

@Singleton
public class EntityModelStopConverter implements EntityModelConverter<StopEntity, StopModel> {
    @Override
    public StopModel entityToModel(StopEntity entity) {
        StopModel model = new StopModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }

    @Override
    public StopEntity modelToEntity(StopModel model) {
        StopEntity entity = new StopEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        return entity;
    }
}
