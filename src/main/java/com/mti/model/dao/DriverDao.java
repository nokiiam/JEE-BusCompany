package com.mti.model.dao;

import com.mti.model.data.DriverModel;

import javax.inject.Named;

@Named
public class DriverDao extends Dao<DriverModel> {

    DriverDao() {
        super(DriverModel.class);
    }

    public DriverModel getByCode(String code) {
        return entityManager.createQuery("SELECT d FROM " + clazz + " d WHERE d.code = " + code, clazz).getSingleResult();
    }
}
