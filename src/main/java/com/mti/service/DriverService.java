package com.mti.service;

import com.mti.model.dao.DriverDao;
import com.mti.model.data.DriverModel;
import com.mti.service.convertor.DriverEntityModelConverter;
import com.mti.service.data.DriverEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DriverService extends Service<DriverEntity, DriverModel, DriverDao> {

    @Inject
    public DriverService(DriverDao dao, DriverEntityModelConverter converter) {
        super(dao, converter);
    }

    @Override
    public DriverEntity create(DriverEntity entity) {
        entity.setCode(entity.getLastname().substring(0, 4) + entity.getFirstname().substring(0, 2));//FIXME take care of clash in driver codes
        DriverModel model = converter.entityToModel(entity);
        dao.create(model);
        return converter.modelToEntity(model); //FIXME should take care of fail from dao
    }

    @Override
    public DriverEntity update(int id, DriverEntity entity) {
        // TODO handle error
        DriverEntity lastEntity = getById(id);
        if (lastEntity == null)
            return null;
        entity.setCode(lastEntity.getCode());
        DriverModel model = converter.entityToModel(entity);
        model.setId(id);
        dao.update(model);
        return converter.modelToEntity(model);
    }

    public DriverEntity getByCode(String code) {
        return converter.modelToEntity(dao.getByCode(code));
    }
}
