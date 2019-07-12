package com.mti.model.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public abstract class Dao<ENTITY_TYPE> {

    private Class<ENTITY_TYPE> clazz;
    private EntityManager entityManager;

    private Class<ENTITY_TYPE> getEntityClass() {
        return clazz;
    }

    private EntityManager getEntityManager() {
        return entityManager;
    }


    Dao(Class<ENTITY_TYPE> clazz, EntityManager entityManager) {
        this.clazz = clazz;
        this.entityManager = entityManager;
    }

    public List<ENTITY_TYPE> findAll() {
        EntityManager em = getEntityManager();
        return em.createQuery("FROM " + getEntityClass().getSimpleName(), this.clazz).getResultList();
    }

    public ENTITY_TYPE findOne(int id) {
        EntityManager em = getEntityManager();
        return em.find(getEntityClass(),id);
    }

    @Transactional
    public void create(ENTITY_TYPE entity) {
        EntityManager em = getEntityManager();
        em.persist(entity);
    }

    @Transactional
    public void update(ENTITY_TYPE entity) {
        EntityManager em = getEntityManager();
        em.merge(entity);
    }

    @Transactional
    public void remove (ENTITY_TYPE entity) {
        EntityManager em = getEntityManager();
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
}
