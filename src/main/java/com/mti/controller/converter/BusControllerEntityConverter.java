package com.mti.controller.converter;

import com.mti.controller.data.BusRequest;
import com.mti.controller.data.BusResponse;
import com.mti.service.data.BusEntity;

public class BusControllerEntityConverter implements ControllerEntityConverter<BusRequest, BusResponse, BusEntity> {
    @Override
    public BusEntity controllerToEntity(BusRequest request) {
        BusEntity stopEntity = new BusEntity();
        stopEntity.setBrand(request.getBrand());
        stopEntity.setCapacity(request.getCapacity());
        stopEntity.setKilometers(request.getKilometers());
        stopEntity.setRegistration(request.getRegistration());
        stopEntity.setReleaseYear(request.getReleaseYear());
        return stopEntity;
    }

    @Override
    public BusResponse entityToController(BusEntity entity) {
        BusResponse stopResponse = new BusResponse();
        stopResponse.setId(entity.getId());
        stopResponse.setBrand(entity.getBrand());
        stopResponse.setCapacity(entity.getCapacity());
        stopResponse.setKilometers(entity.getKilometers());
        stopResponse.setRegistration(entity.getRegistration());
        stopResponse.setReleaseYear(entity.getReleaseYear());
        return stopResponse;
    }
}
