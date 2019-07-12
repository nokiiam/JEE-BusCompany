package com.mti.service;

import com.mti.model.dao.StopDao;
import com.mti.model.data.StopModel;
import com.mti.service.convertor.EntityModelStopConverter;
import com.mti.service.data.StopEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class StopService extends Service<StopEntity, StopModel, StopDao> {

    @Inject
    public StopService(StopDao dao, EntityModelStopConverter converter) {
        super(dao, converter);
    }
}
