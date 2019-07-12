package com.mti.controller;

import com.mti.controller.converter.ControllerEntityConverter;
import com.mti.controller.data.AbstractRequest;
import com.mti.controller.data.AbstractResponse;
import com.mti.model.dao.Dao;
import com.mti.model.data.Model;
import com.mti.service.Service;
import com.mti.service.data.Entity;

import javax.ws.rs.*;
import java.util.List;
import java.util.stream.Collectors;

interface Controller<REQUEST_TYPE extends AbstractRequest, RESPONSE_TYPE extends AbstractResponse, ENTITY_TYPE extends Entity, MODEL_TYPE extends Model,
        DAO_TYPE extends Dao<MODEL_TYPE>,
        SERVICE_TYPE extends Service<ENTITY_TYPE, MODEL_TYPE, DAO_TYPE>> {

    SERVICE_TYPE getService();

    ControllerEntityConverter<REQUEST_TYPE, RESPONSE_TYPE, ENTITY_TYPE> getConverter();

    @GET
    default List<RESPONSE_TYPE> getList() {
       /*List<RESPONSE_TYPE> responses = new ArrayList<>();
        getService().getList().forEach(entity ->{responses.add(getConverter().entityToController(entity));});
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return javax.ws.rs.core.AbstractResponse.ok(ow.writeValueAsString(responses)).build();
        } catch (Exception e) {
            return javax.ws.rs.core.AbstractResponse.serverError().build();
        }*/
        return getService().getList()
                .stream()
                .map(getConverter()::entityToController)
                .collect(Collectors.toList()); //TODO : render response
    }

    @GET
    @Path("/{id}")
    default RESPONSE_TYPE getById(@PathParam("id") final int id) {
        return getConverter().entityToController(getService().getById(id));//TODO : render response
    }

    @POST
    default RESPONSE_TYPE create(REQUEST_TYPE request) {
        ENTITY_TYPE entity = getConverter().controllerToEntity(request);
        return getConverter().entityToController(getService().create(entity));//TODO : render response
    }

    @DELETE
    @Path("/{id}")
    default void delete(@PathParam("id") int id) {
        getService().delete(id);
    }

    @PUT
    @Path("/{id}")
    default RESPONSE_TYPE update(@PathParam("id") int id, REQUEST_TYPE request) {
        ENTITY_TYPE entity = getConverter().controllerToEntity(request);
        return getConverter().entityToController(getService().update(id, entity));
    }
}
