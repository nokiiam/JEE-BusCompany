package com.mti.service;

import com.mti.model.dao.StopDao;
import com.mti.model.data.StopModel;
import com.mti.service.convertor.StopEntityModelConverter;
import com.mti.service.data.StopEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class StopService extends Service<StopEntity, StopModel, StopDao> {

    @Inject
    public StopService(StopDao dao, StopEntityModelConverter converter) {
        super(dao, converter);
    }
}
