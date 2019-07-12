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


@Produces("application/json; charset=UTF-8")
public interface Controller<REQUEST_TYPE extends AbstractRequest, RESPONSE_TYPE extends AbstractResponse, ENTITY_TYPE extends Entity, MODEL_TYPE extends Model,
        DAO_TYPE extends Dao<MODEL_TYPE>,
        SERVICE_TYPE extends Service<ENTITY_TYPE, MODEL_TYPE, DAO_TYPE>> {

    SERVICE_TYPE getService();

    ControllerEntityConverter<REQUEST_TYPE, RESPONSE_TYPE, ENTITY_TYPE> getConverter();

    /**
     * Handle 'GET' requests on the controller endpoint
     *
     * @return
     */
    @GET
    default List<RESPONSE_TYPE> getList() {
        return getService().getList()
                .stream()
                .map(getConverter()::entityToController)
                .collect(Collectors.toList()); //TODO : render response
    }

    /**
     * Handle 'GET' requests on the controller endpoint for a specific id
     *
     * @return the requested element or null if no element was found
     */
    @GET
    @Path("/{id}")
    default RESPONSE_TYPE getById(@PathParam("id") final int id) {
        return getConverter().entityToController(getService().getById(id));//TODO : render response
    }

    /**
     * Handle 'POST' requests on the controller endpoint
     * Create a new element by parsing body of the request
     *
     * @param request the element to create
     * @return the created element or null if the creation failed
     */
    @POST
    default RESPONSE_TYPE create(REQUEST_TYPE request) {
        ENTITY_TYPE entity = getConverter().controllerToEntity(request);
        return getConverter().entityToController(getService().create(entity));//TODO : render response
    }

    /**
     * Handle 'DELETE' requests on the controller endpoint for a specific id
     * Delete the element with the specified <code>param</code> id
     *
     * @return
     */
    @DELETE
    @Path("/{id}")
    default void delete(@PathParam("id") int id) {
        getService().delete(id);
    }

    /**
     * Handle 'PUT' requests on the controller endpoint for a specific id
     * Update an element with the body of the request
     *
     * @param id      the id of the element to update
     * @param request the new state of the element
     * @return the created element or null if the creation failed
     */
    @PUT
    @Path("/{id}")
    default RESPONSE_TYPE update(@PathParam("id") int id, REQUEST_TYPE request) {
        ENTITY_TYPE entity = getConverter().controllerToEntity(request);
        return getConverter().entityToController(getService().update(id, entity));
    }
}
