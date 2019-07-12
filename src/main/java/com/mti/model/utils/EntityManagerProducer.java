package com.mti.model.utils;


import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

public class EntityManagerProducer {

    public Map<EntityManager, EntityManagerFactory> map = new HashMap<>();

    @PersistenceContext(unitName = "bdd")
    EntityManager entityManager;

    @Produces @Singleton
    public EntityManager createCustomerDbEm() {
        return entityManager;
    }

    public void disposeProdEm(@Disposes EntityManager em) {
        em.close();
    }
}
