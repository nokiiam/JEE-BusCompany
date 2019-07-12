package com.mti.model.dao;

import com.mti.model.data.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public abstract class Dao<MODEL_TYPE extends Model> {

    private Class<MODEL_TYPE> clazz;

    @PersistenceContext(unitName = "bdd")
    private EntityManager entityManager;

    Dao(Class<MODEL_TYPE> clazz, EntityManager entityManager) {
        this.clazz = clazz;
        this.entityManager = entityManager;
    }

    private Class<MODEL_TYPE> getEntityClass() {
        return clazz;
    }

    private EntityManager getEntityManager() {
        return entityManager;
    }

    public List<MODEL_TYPE> getList() {
        EntityManager em = getEntityManager();
        return em.createQuery("FROM " + getEntityClass().getSimpleName(), this.clazz).getResultList();
    }

    public MODEL_TYPE getById(int id) {
        EntityManager em = getEntityManager();
        return em.find(getEntityClass(), id);
    }

    @Transactional
    public void create(MODEL_TYPE entity) {
        EntityManager em = getEntityManager();
        em.persist(entity);
    }

    @Transactional
    public void update(MODEL_TYPE entity) {
        EntityManager em = getEntityManager();
        em.merge(entity);
    }

    @Transactional
    public void remove(MODEL_TYPE entity) {
        EntityManager em = getEntityManager();
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
}
