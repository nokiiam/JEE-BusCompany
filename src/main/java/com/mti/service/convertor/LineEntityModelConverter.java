package com.mti.service.convertor;

import com.mti.model.data.LineModel;
import com.mti.service.data.LineEntity;

import javax.inject.Singleton;

@Singleton
public class LineEntityModelConverter implements EntityModelConverter<LineEntity, LineModel> {
    @Override
    public LineModel entityToModel(LineEntity entity) {
        LineModel model = new LineModel();
        model.setId(entity.getId());
        model.setNumber(entity.getNumber());
        return model;
    }

    @Override
    public LineEntity modelToEntity(LineModel model) {
        LineEntity entity = new LineEntity();
        entity.setId(model.getId());
        entity.setNumber(model.getNumber());
        return entity;
    }
}
