package com.mti.controller;

import com.mti.controller.converter.BusControllerEntityConverter;
import com.mti.controller.converter.ControllerEntityConverter;
import com.mti.controller.data.BusRequest;
import com.mti.controller.data.BusResponse;
import com.mti.model.dao.BusDao;
import com.mti.model.data.BusModel;
import com.mti.service.BusService;
import com.mti.service.data.BusEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Controller for lines
 * Handles requests to '/buses'
 */
@RequestScoped
@Path("/buses")
@Named
public class BusController implements Controller<BusRequest, BusResponse, BusEntity, BusModel, BusDao, BusService> {

    private String brand;
    private String registration;
    private Integer capacity;
    private Integer kilometers;
    private String releaseYear;

    @Inject
    private BusService service;
    @Inject
    private BusControllerEntityConverter converter;

    @Override
    public BusService getService() {
        return service;
    }

    @Override
    public ControllerEntityConverter<BusRequest, BusResponse, BusEntity> getConverter() {
        return converter;
    }

    public Response formCreate() {
        SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
        BusRequest busRequest = new BusRequest();
        busRequest.setBrand(brand);
        busRequest.setRegistration(registration);
        busRequest.setCapacity(capacity);
        busRequest.setKilometers(kilometers);
        try {
            busRequest.setReleaseYear(formatter.parse(releaseYear));
        } catch (ParseException e) {
            return null;
        }
        return create(busRequest);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getBrand() {
        return brand;
    }

    public String getRegistration() {
        return registration;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public String getReleaseYear() {
        return releaseYear;
    }
}
