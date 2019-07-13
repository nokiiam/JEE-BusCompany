package com.mti.service;

import com.mti.model.dao.DriverDao;
import com.mti.model.data.DriverModel;
import com.mti.service.convertor.DriverEntityModelConverter;
import com.mti.service.data.DriverEntity;
import com.mti.utils.tools.Encryptor;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DriverService extends Service<DriverEntity, DriverModel, DriverDao> {

    @Inject
    public DriverService(DriverDao dao, DriverEntityModelConverter converter) {
        super(dao, converter);
    }

    @Override
    public DriverEntity create(DriverEntity entity) {
        entity.setCode(createCode(entity.getLastname(), entity.getFirstname()));
        DriverModel model = converter.entityToModel(entity);
        dao.create(model);
        return converter.modelToEntity(model);
    }

    @Override
    public DriverEntity update(int id, DriverEntity entity) {
        DriverEntity lastEntity = getById(id);
        if (lastEntity == null)
            return null;
        entity.setCode(lastEntity.getCode());
        DriverModel model = converter.entityToModel(entity);
        model.setId(id);
        dao.update(model);
        return converter.modelToEntity(model);
    }

    private String createCode(String lastname, String firstname) {
        String code;
        int lengthLast = 4;
        int lengthFirst = 2;
        do {
            if (lengthFirst == 0) {
                code = Encryptor.getRandomDriverCode();
            } else {
                code = lastname.substring(0, Math.min(lengthLast, lastname.length()))
                        + firstname.substring(0, Math.min(lengthFirst, firstname.length()));
            }
            if (dao.getByCode(code) != null) {
                code = null;
                if (lengthLast == 1) {
                    lengthFirst--;
                } else {
                    lengthLast--;
                }
            }
        } while (code == null);
        return code;
    }
}
