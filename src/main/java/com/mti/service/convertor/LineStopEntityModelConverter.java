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
    LineDao lineDao;

    @Inject
    StopDao stopDao;
    
    @Inject
    LineEntityModelConverter lineConverter;

    @Inject
    StopEntityModelConverter stopConverter;

    @Override
    public LineStopModel entityToModel(LineStopEntity entity) {
        LineModel lineModel = lineDao.getById(entity.getLine().getId());
        if (lineModel == null)
            return null;

        StopModel stopModel = stopDao.getById(entity.getStop().getId());
        if (stopModel == null)
            return null;
        
        LineStopModel lineStopModel = new LineStopModel();

        lineStopModel.setLine(lineModel);
        lineStopModel.setStop(stopModel);
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
