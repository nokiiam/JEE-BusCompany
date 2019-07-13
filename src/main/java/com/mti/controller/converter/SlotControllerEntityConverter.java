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

    @Inject
    BusControllerEntityConverter busConverter;

    @Inject
    DriverControllerEntityConverter driverConverter;

    @Inject
    LineControllerEntityConverter lineConverter;

    @Override
    public SlotEntity controllerToEntity(SlotRequest request) {
        SlotEntity slotEntity = new SlotEntity();

        slotEntity.setDate(request.getDate());
        slotEntity.setMorning(request.getMorning());

        BusEntity bus = new BusEntity();
        bus.setId(request.getBus());
        slotEntity.setBus(bus);

        DriverEntity driver = new DriverEntity();
        driver.setId(request.getDriver());
        slotEntity.setDriver(driver);

        LineEntity line = new LineEntity();
        line.setId(request.getLine());
        slotEntity.setLine(line);

        return slotEntity;
    }

    @Override
    public SlotResponse entityToController(SlotEntity entity) {
        SlotResponse slotResponse = new SlotResponse();

        slotResponse.setId(entity.getId());
        slotResponse.setDate(entity.getDate());
        slotResponse.setMorning(entity.getMorning());
        slotResponse.setBus(busConverter.entityToController(entity.getBus()));
        slotResponse.setDriver(driverConverter.entityToController(entity.getDriver()));
        slotResponse.setLine(lineConverter.entityToController(entity.getLine()));

        return slotResponse;
    }
}
