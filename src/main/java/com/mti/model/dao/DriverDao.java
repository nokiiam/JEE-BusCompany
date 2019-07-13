package com.mti.model.dao;

import com.mti.model.data.DriverModel;

import javax.inject.Named;
import javax.persistence.NoResultException;

@Named
public class DriverDao extends Dao<DriverModel> {

    DriverDao() {
        super(DriverModel.class);
    }

    public DriverModel getByCode(String code) {
        try {
            return (DriverModel) entityManager.createQuery("SELECT s FROM DriverModel s WHERE s.code = :c")
                    .setParameter("c", code)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

}
