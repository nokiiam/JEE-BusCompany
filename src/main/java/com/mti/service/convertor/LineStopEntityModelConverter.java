package com.mti.service.convertor;

import com.mti.model.dao.LineDao;
import com.mti.model.dao.StopDao;
import com.mti.model.data.LineModel;
import com.mti.model.data.LineStopModel;
import com.mti.model.data.StopModel;
import com.mti.service.data.LineStopEntity;

import javax.inject.Inject;

public class LineStopEntityModelConverter implements EntityModelConverter<LineStopEntity, LineStopModel> {
    @Inject
    LineEntityModelConverter lineConverter;

    @Inject
    StopEntityModelConverter stopConverter;

    @Override
    public LineStopModel entityToModel(LineStopEntity entity) {
        LineStopModel lineStopModel = new LineStopModel();

        lineStopModel.setId(entity.getId());
        lineStopModel.setLine(lineConverter.entityToModel(entity.getLine()));
        lineStopModel.setStop(stopConverter.entityToModel(entity.getStop()));
        lineStopModel.setOrder(entity.getOrder());

        return lineStopModel;
    }

    @Override
    public LineStopEntity modelToEntity(LineStopModel model) {
        LineStopEntity lineStopEntity = new LineStopEntity();

        lineStopEntity.setId(model.getId());
        lineStopEntity.setLine(lineConverter.modelToEntity(model.getLine()));
        lineStopEntity.setStop(stopConverter.modelToEntity(model.getStop()));
        lineStopEntity.setOrder(model.getOrder());
        
        return lineStopEntity;
    }
}
