package com.mti.controller.converter;

import com.mti.controller.data.SlotRequest;
import com.mti.controller.data.SlotResponse;
import com.mti.service.BusService;
import com.mti.service.DriverService;
import com.mti.service.LineService;
import com.mti.service.data.BusEntity;
import com.mti.service.data.DriverEntity;
import com.mti.service.data.LineEntity;
import com.mti.service.data.SlotEntity;

import javax.inject.Inject;

public class SlotControllerEntityConverter implements ControllerEntityConverter<SlotRequest, SlotResponse, SlotEntity> {

    @Inject
    BusService busService;

    @Inject
    DriverService driverService;

    @Inject
    LineService lineService;

    @Override
    public SlotEntity controllerToEntity(SlotRequest request) {
        BusEntity busEntity = busService.getById(request.getBus());
        if (busEntity == null)
            return null;

        DriverEntity driverEntity = driverService.getById(request.getBus());
        if (driverEntity == null)
            return null;

        LineEntity lineEntity = lineService.getById(request.getLine());
        if (lineEntity == null)
            return null;

        SlotEntity slotEntity = new SlotEntity();

        slotEntity.setDate(request.getDate());
        slotEntity.setMorning(request.getMorning());
        slotEntity.setBus(busEntity);
        slotEntity.setDriver(driverEntity);
        slotEntity.setLine(lineEntity);

        return slotEntity;
    }

    @Override
    public SlotResponse entityToController(SlotEntity entity) {
        SlotResponse slotResponse = new SlotResponse();

        slotResponse.setId(entity.getId());
        slotResponse.setDate(entity.getDate());
        slotResponse.setMorning(entity.getMorning());
        slotResponse.setBus(entity.getBus().getId());
        slotResponse.setDriver(entity.getDriver().getId());
        slotResponse.setLine(entity.getLine().getId());

        return slotResponse;
    }
}
