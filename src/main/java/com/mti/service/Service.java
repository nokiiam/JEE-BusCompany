package com.mti.service;

import com.mti.model.dao.Dao;
import com.mti.model.data.Model;
import com.mti.service.convertor.EntityModelConverter;
import com.mti.service.data.Entity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Service<ENTITY_TYPE extends Entity, MODEL_TYPE extends Model, DAO_TYPE extends Dao<MODEL_TYPE>> {

    protected DAO_TYPE dao;
    protected EntityModelConverter<ENTITY_TYPE, MODEL_TYPE> converter;


    Service(DAO_TYPE dao, EntityModelConverter<ENTITY_TYPE, MODEL_TYPE> converter) {
        this.dao = dao;
        this.converter = converter;
    }

    /**
     * Return all element of type 'ENTITY_TYPE'
     *
     * @return List of ENTITY_TYPE
     */
    public List<ENTITY_TYPE> getList() {
        return dao.getList()
                .stream()
                .filter(Objects::nonNull)
                .map(converter::modelToEntity)
                .collect(Collectors.toList());
    }

    /**
     * Return the element with the selected id
     *
     * @param id the id of the element to be return
     * @return the element or null if no element was found
     */
    public ENTITY_TYPE getById(int id) {
        MODEL_TYPE model = dao.getById(id);
        if (model == null)
            return null;
        return converter.modelToEntity(model);
    }


    /**
     * Create and return an element of type 'ENTITY_TYPE'
     *
     * @param entity the entity to create
     * @return return the entity created or null if the creation failed
     */

    public ENTITY_TYPE create(ENTITY_TYPE entity) {
        MODEL_TYPE model = converter.entityToModel(entity);
        dao.create(model);
        // TODO handle error
        return converter.modelToEntity(model);
    }

    /**
     * Delete the element with the selected id
     *
     * @param id id of the entity to delete
     */

    public void delete(int id) {
        // TODO handle error
        delete(getById(id));
    }

    /**
     * Delete an element
     *
     * @param entity the entity to delete
     */
    private void delete(ENTITY_TYPE entity) {
        // TODO handle error
        dao.remove(converter.entityToModel(entity));
    }

    /**
     * Update the element with the selected id
     *
     * @param id the id of the entity to update
     * @param entity new state of the entity
     * @return the new entity or null if the update failed
     */
    public ENTITY_TYPE update(int id, ENTITY_TYPE entity) {
        MODEL_TYPE model = dao.getById(id);
        if (model == null)
            return null;

        model = converter.entityToModel(entity);
        model.setId(id);
        return converter.modelToEntity(dao.update(model));
    }
}
