package com.mti.service.convertor;

import com.mti.model.data.BusBrand;
import com.mti.model.data.BusModel;
import com.mti.service.data.BusEntity;

import javax.inject.Singleton;

@Singleton
public class BusEntityModelConverter implements EntityModelConverter<BusEntity, BusModel> {
    @Override
    public BusModel entityToModel(BusEntity request) {
        BusModel model = new BusModel();
        model.setId(request.getId());
        model.setBrand(request.getBrand() != null ? BusBrand.valueOf(request.getBrand()) : null);
        model.setCapacity(request.getCapacity());
        model.setKilometers(request.getKilometers());
        model.setRegistration(request.getRegistration());
        model.setReleaseYear(request.getReleaseYear());
        return model;
    }

    @Override
    public BusEntity modelToEntity(BusModel entity) {
        BusEntity stopResponse = new BusEntity();
        stopResponse.setId(entity.getId());
        stopResponse.setBrand(entity.getBrand() != null ? entity.getBrand().toString() : null);
        stopResponse.setCapacity(entity.getCapacity());
        stopResponse.setKilometers(entity.getKilometers());
        stopResponse.setRegistration(entity.getRegistration());
        stopResponse.setReleaseYear(entity.getReleaseYear());
        return stopResponse;
    }
}