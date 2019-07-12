package com.mti.model.dao;

import com.mti.model.data.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.RollbackException;
import javax.transaction.Transactional;
import java.util.List;

public abstract class Dao<MODEL_TYPE extends Model> {

    private Class<MODEL_TYPE> clazz;

    @PersistenceContext(unitName = "bdd")
    private EntityManager entityManager;

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
    public void create(MODEL_TYPE entity) throws RollbackException {
        entityManager.persist(entity);
    }

    @Transactional
    public MODEL_TYPE update(MODEL_TYPE entity) throws RollbackException {
        return entityManager.merge(entity);
    }

    @Transactional
    public void remove(MODEL_TYPE entity) throws RollbackException {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
}
