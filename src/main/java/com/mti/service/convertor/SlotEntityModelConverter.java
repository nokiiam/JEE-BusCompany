package com.mti.service.convertor;

import com.mti.model.data.BusModel;
import com.mti.model.data.DriverModel;
import com.mti.model.data.LineModel;
import com.mti.model.data.SlotModel;
import com.mti.service.data.SlotEntity;

import javax.inject.Inject;

public class SlotEntityModelConverter implements EntityModelConverter<SlotEntity, SlotModel> {

    @Inject
    LineEntityModelConverter lineConverter;

    @Inject
    DriverEntityModelConverter driverConverter;

    @Inject
    BusEntityModelConverter busConverter;

    @Override
    public SlotModel entityToModel(SlotEntity entity) {
        SlotModel slotModel = new SlotModel();

        slotModel.setId(entity.getId());
        slotModel.setMorning(entity.getMorning());
        slotModel.setDate(entity.getDate());
        slotModel.setLine(lineConverter.entityToModel(entity.getLine()));
        slotModel.setDriver(driverConverter.entityToModel(entity.getDriver()));
        slotModel.setBus(busConverter.entityToModel(entity.getBus()));

        return slotModel;
    }

    @Override
    public SlotEntity modelToEntity(SlotModel model) {
        SlotEntity slotEntity = new SlotEntity();

        slotEntity.setId(model.getId());
        slotEntity.setMorning(model.getMorning());
        slotEntity.setDate(model.getDate());
        slotEntity.setLine(lineConverter.modelToEntity(model.getLine()));
        slotEntity.setDriver(driverConverter.modelToEntity(model.getDriver()));
        slotEntity.setBus(busConverter.modelToEntity(model.getBus()));

        return slotEntity;
    }
}
