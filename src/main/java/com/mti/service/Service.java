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
     * Function which return all element of ENTITY_TYPE
     *
     * @return List with all element of ENTITY_TYPE
     */
    public List<ENTITY_TYPE> getList() {
        return dao.getList()
                .stream()
                .filter(Objects::nonNull)
                .map(converter::modelToEntity)
                .collect(Collectors.toList());
    }

    /**
     * Function which should return the element with the
     * selected id if it exist
     * @param id id of the element to be return
     * @return null if no element found, the element otherwise
     */
    public ENTITY_TYPE getById(int id) {
        MODEL_TYPE model = dao.getById(id);
        if (model == null)
            return null;
        return converter.modelToEntity(model);
    }


    /**
     * Function which should create and return an element
     * @param entity entity to create in the database
     * @return return the entity created
     */

    public ENTITY_TYPE create(ENTITY_TYPE entity) {
        MODEL_TYPE model = converter.entityToModel(entity);
        dao.create(model);
        // TODO handle error
        return converter.modelToEntity(model);
    }

    /**
     * Should delete an entity by his id
     * @param id id of the entity to delete
     */

    public void delete(int id) {
        // TODO handle error
        delete(getById(id));
    }

    /**
     * Delete an entity
     * @param entity entity to delete
     */
    private void delete(ENTITY_TYPE entity) {
        // TODO handle error
        dao.remove(converter.entityToModel(entity));
    }

    /**
     * Update an entity
     * @param id id of the entity to delete
     * @param entity new state of the entity
     * @return null if entity existed, or the new entity otherwise
     */
    public ENTITY_TYPE update(int id, ENTITY_TYPE entity) {
        ENTITY_TYPE lastEntity = getById(id);
        if (lastEntity == null)
            return null;

        MODEL_TYPE model = converter.entityToModel(entity);
        model.setId(id);
        dao.update(model);
        return converter.modelToEntity(model);
    }
}
