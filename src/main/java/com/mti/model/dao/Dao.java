package com.mti.model.dao;

import com.mti.model.data.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public abstract class Dao<MODEL_TYPE extends Model> {

    protected Class<MODEL_TYPE> clazz;

    @PersistenceContext(unitName = "bdd")
    protected EntityManager entityManager;

    Dao(Class<MODEL_TYPE> clazz) {
        this.clazz = clazz;
    }


    public List<MODEL_TYPE> getList() {
        return entityManager.createQuery("FROM " + clazz.getSimpleName(), this.clazz).getResultList();
    }

    public MODEL_TYPE getById(int id) {
        return entityManager.find(clazz, id);
    }

    @Transactional
    public void create(MODEL_TYPE entity) {
        entityManager.persist(entity);
    }

    @Transactional
    public void update(MODEL_TYPE entity) {
        entityManager.merge(entity);
    }

    @Transactional
    public void remove(MODEL_TYPE entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
}
