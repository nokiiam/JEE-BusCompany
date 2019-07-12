package com.mti.service;

import com.mti.model.dao.LineStopDao;
import com.mti.model.data.LineStopModel;
import com.mti.service.convertor.LineStopEntityModelConverter;
import com.mti.service.data.LineStopEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LineStopService extends Service<LineStopEntity, LineStopModel, LineStopDao> {

    @Inject
    public LineStopService(LineStopDao dao, LineStopEntityModelConverter converter) {
        super(dao, converter);
    }
}
