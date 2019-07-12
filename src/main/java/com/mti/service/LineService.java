package com.mti.service;

import com.mti.model.dao.LineDao;
import com.mti.model.data.LineModel;
import com.mti.service.convertor.LineEntityModelConverter;
import com.mti.service.data.LineEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LineService extends Service<LineEntity, LineModel, LineDao> {

    @Inject
    public LineService(LineDao dao, LineEntityModelConverter converter) {
        super(dao, converter);
    }
}
