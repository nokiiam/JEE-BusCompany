package com.mti.model.dao;

import com.mti.model.data.SlotModel;

import javax.inject.Named;
import java.util.List;


@Named
public class SlotDao extends Dao<SlotModel> {

    SlotDao() {
        super(SlotModel.class);
    }

    public List<SlotModel> getAllSlotFromDriver(int driverId) {
        return entityManager.createQuery("SELECT sl FROM SlotModel sl WHERE sl.driver.id = :driver_id", SlotModel.class)
                .setParameter("driver_id", driverId)
                .getResultList();
    }
}
