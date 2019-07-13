package com.mti.controller;

import com.mti.controller.converter.ControllerEntityConverter;
import com.mti.controller.converter.SlotControllerEntityConverter;
import com.mti.controller.data.SlotRequest;
import com.mti.controller.data.SlotResponse;
import com.mti.model.dao.SlotDao;
import com.mti.model.data.SlotModel;
import com.mti.service.SlotService;
import com.mti.service.data.SlotEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Controller for lines
 * Handles requests to '/slots'
 */
@RequestScoped
@Path("/slots")
@Named
public class SlotController implements Controller<SlotRequest, SlotResponse, SlotEntity, SlotModel, SlotDao, SlotService> {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private String date;
    private Boolean isMorning;
    private Integer driver;
    private Integer bus;

    @Inject
    private SlotService service;
    @Inject
    private SlotControllerEntityConverter converter;

    @Override
    public SlotService getService() {
        return service;
    }

    @Override
    public ControllerEntityConverter<SlotRequest, SlotResponse, SlotEntity> getConverter() {
        return converter;
    }

    @Override
    public Response update(int id, SlotRequest request) {
        return Response
                .status(405).build();
    }

    private Integer line;

    public Response formCreate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SlotRequest slotRequest = new SlotRequest();
        slotRequest.setBus(bus);
        slotRequest.setDriver(driver);
        slotRequest.setMorning(isMorning);
        try {
            slotRequest.setDate(formatter.parse(date));
        } catch (ParseException e) {
            return null;
        }
        return create(slotRequest);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getMorning() {
        return isMorning;
    }

    public void setMorning(Boolean morning) {
        isMorning = morning;
    }

    public Integer getDriver() {
        return driver;
    }

    public void setDriver(Integer driver) {
        this.driver = driver;
    }

    public Integer getBus() {
        return bus;
    }

    public void setBus(Integer bus) {
        this.bus = bus;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }
}
