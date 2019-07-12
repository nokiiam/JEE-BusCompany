package com.mti.service;

import com.mti.model.dao.SlotDao;
import com.mti.model.data.SlotModel;
import com.mti.service.convertor.SlotEntityModelConverter;
import com.mti.service.data.SlotEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SlotService extends Service<SlotEntity, SlotModel, SlotDao> {

    @Inject
    public SlotService(SlotDao dao, SlotEntityModelConverter converter) {
        super(dao, converter);
    }

    //TODO create
}
