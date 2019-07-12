package com.mti.service.convertor;

import com.mti.model.data.DriverModel;
import com.mti.model.data.DriverStatus;
import com.mti.service.data.DriverEntity;

import javax.inject.Singleton;
import java.util.Calendar;
import java.util.Date;

@Singleton
public class DriverEntityModelConverter implements EntityModelConverter<DriverEntity, DriverModel> {
    @Override
    public DriverModel entityToModel(DriverEntity entity) throws IllegalArgumentException {
        if (!checkValidDate(entity.getBirthDate()))
            throw new IllegalArgumentException("Birthday should be after 1900 and driver should be major");
        DriverModel model = new DriverModel();
        model.setId(entity.getId());
        model.setBirthDate(entity.getBirthDate());
        model.setFirstname(entity.getFirstname());
        model.setLastname(entity.getLastname());
        model.setCode(entity.getCode());
        model.setStatus(DriverStatus.fromInteger(entity.getStatus()));
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
        entity.setStatus(model.getStatus().toInteger());
        return entity;
    }

    private boolean checkValidDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date maxValue = new Date(calendar.get(Calendar.YEAR) - 18);
        Date minValue = new Date(1900);
        return date.before(maxValue) && date.after(minValue);
    }
}
