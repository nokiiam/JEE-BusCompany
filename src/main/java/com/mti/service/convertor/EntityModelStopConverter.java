package com.mti.service.convertor;

import com.mti.model.data.StopModel;
import com.mti.service.data.StopEntity;

import javax.inject.Singleton;

@Singleton
public class EntityModelStopConverter implements EntityModelConverter<StopEntity, StopModel> {
    @Override
    public StopModel entityToModel(StopEntity entity) {
        return null;
    }

    @Override
    public StopEntity modelToEntity(StopModel model) {
        return null;
    }
}
