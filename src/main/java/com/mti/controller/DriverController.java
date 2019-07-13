package com.mti.controller;

import com.mti.controller.converter.ControllerEntityConverter;
import com.mti.controller.converter.DriverControllerEntityConverter;
import com.mti.controller.data.DriverRequest;
import com.mti.controller.data.DriverResponse;
import com.mti.model.dao.DriverDao;
import com.mti.model.data.DriverModel;
import com.mti.service.DriverService;
import com.mti.service.data.DriverEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Controller for lines
 * Handles requests to '/drivers'
 */
@RequestScoped
@Path("/drivers")
@Named
public class DriverController implements Controller<DriverRequest, DriverResponse, DriverEntity, DriverModel, DriverDao, DriverService> {

    private String firstname;
    private String lastname;
    private String birthdate;
    private Integer status;

    @Inject
    private DriverService service;
    @Inject
    private DriverControllerEntityConverter converter;

    @Override
    public DriverService getService() {
        return service;
    }

    @Override
    public ControllerEntityConverter<DriverRequest, DriverResponse, DriverEntity> getConverter() {
        return converter;
    }

    public Response formCreate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        DriverRequest driverRequest = new DriverRequest();
        driverRequest.setFirstname(firstname);
        driverRequest.setLastname(lastname);
        driverRequest.setStatus(status);
        try {
            driverRequest.setBirthDate(formatter.parse(birthdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return create(driverRequest);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
