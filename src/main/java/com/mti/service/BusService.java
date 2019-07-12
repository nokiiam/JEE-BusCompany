package com.mti.service;

import com.mti.model.dao.BusDao;
import com.mti.model.data.BusModel;
import com.mti.service.convertor.BusEntityModelConverter;
import com.mti.service.data.BusEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BusService extends Service<BusEntity, BusModel, BusDao> {

    @Inject
    public BusService(BusDao dao, BusEntityModelConverter converter) {
        super(dao, converter);
    }
}
