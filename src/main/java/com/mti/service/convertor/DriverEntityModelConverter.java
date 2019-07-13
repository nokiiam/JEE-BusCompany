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
        if (entity.getBirthDate() != null && !checkValidDate(entity.getBirthDate()))
            throw new IllegalArgumentException("Birthday should be after 1900 and driver should be major");
        DriverModel model = new DriverModel();
        model.setId(entity.getId());
        model.setBirthDate(entity.getBirthDate());
        model.setFirstname(entity.getFirstname());
        model.setLastname(entity.getLastname());
        model.setCode(entity.getCode());
        model.setStatus(DriverStatus.fromInteger(entity.getStatus()));
        if (entity.getStatus() != null && entity.getStatus() >= 0 && model.getStatus() == null)
            throw new IllegalArgumentException("Status should be between 0 and 4");
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
        entity.setStatus(model.getStatus().ordinal());
        return entity;
    }

    private boolean checkValidDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(calendar.get(Calendar.YEAR) - 18, Calendar.JANUARY, 0, 0, 0);
        Date maxValue = calendar.getTime();
        calendar.set(Calendar.YEAR, 1900);
        Date minValue = calendar.getTime();
        return date.before(maxValue) && date.after(minValue);
    }
}
