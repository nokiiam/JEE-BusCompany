package com.mti.service;

import com.mti.model.dao.Dao;
import com.mti.model.data.Model;
import com.mti.service.convertor.EntityModelConverter;
import com.mti.service.data.Entity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Service<ENTITY_TYPE extends Entity, MODEL_TYPE extends Model, DAO_TYPE extends Dao<MODEL_TYPE>> {

    private DAO_TYPE dao;
    private EntityModelConverter<ENTITY_TYPE, MODEL_TYPE> converter;


    Service(DAO_TYPE dao, EntityModelConverter<ENTITY_TYPE, MODEL_TYPE> converter) {
        this.dao = dao;
        this.converter = converter;
    }

    public List<ENTITY_TYPE> getList() {
        return dao.getList()
                .stream()
                .filter(Objects::nonNull)
                .map(converter::modelToEntity)
                .collect(Collectors.toList());
    }

    public ENTITY_TYPE getById(int id) {
        return converter.modelToEntity(dao.getById(id));
    }


    public ENTITY_TYPE create(ENTITY_TYPE entity) {
        MODEL_TYPE model = converter.entityToModel(entity);
        dao.create(model);
        return converter.modelToEntity(model);
    }

    public void delete(int id) {
        delete(getById(id));
    }

    private void delete(ENTITY_TYPE entity) {
        dao.remove(converter.entityToModel(entity));
    }

    public ENTITY_TYPE update(int id, ENTITY_TYPE entity) {
        MODEL_TYPE model = converter.entityToModel(entity);
        model.setId(id);
        dao.update(model);
        return converter.modelToEntity(model);
    }
}
