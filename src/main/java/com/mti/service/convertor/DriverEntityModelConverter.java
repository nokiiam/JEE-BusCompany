package com.mti.service.convertor;

import com.mti.model.data.DriverModel;
import com.mti.service.data.DriverEntity;

import javax.inject.Singleton;

@Singleton
public class DriverEntityModelConverter implements EntityModelConverter<DriverEntity, DriverModel> {
    @Override
    public DriverModel entityToModel(DriverEntity entity) {
        DriverModel model = new DriverModel();
        model.setId(entity.getId());
        model.setBirthDate(entity.getBirthDate());
        model.setFirstname(entity.getFirstname());
        model.setLastname(entity.getLastname());
        model.setStatus(entity.getStatus());
        return model;
    }

    @Override
    public DriverEntity modelToEntity(DriverModel model) {
        DriverEntity entity = new DriverEntity();
        entity.setId(model.getId());
        entity.setBirthDate(model.getBirthDate());
        entity.setFirstname(model.getFirstname());
        entity.setLastname(model.getLastname());
        entity.setCode(model.getCode());
        entity.setStatus(model.getStatus());
        return entity;
    }
}
