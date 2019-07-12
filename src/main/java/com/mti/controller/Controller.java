package com.mti.controller;

import com.mti.model.dao.Dao;
import com.mti.service.Service;

interface Controller<REQUEST_MODEL_TYPE, RESPONSE_MODEL_TYPE, ENTITY_TYPE, DAO_MODEL_TYPE,
        DAO_TYPE extends Dao<DAO_MODEL_TYPE>,
        SERVICE_TYPE extends Service<ENTITY_TYPE, DAO_MODEL_TYPE,DAO_TYPE>> {
}
