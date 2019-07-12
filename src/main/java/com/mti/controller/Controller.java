package com.mti.controller;

import com.mti.model.dao.Dao;
import com.mti.model.data.Model;
import com.mti.service.Service;

interface Controller<REQUEST_MODEL_TYPE, RESPONSE_MODEL_TYPE, ENTITY_TYPE, MODEL_TYPE extends Model,
        DAO_TYPE extends Dao<MODEL_TYPE>,
        SERVICE_TYPE extends Service<ENTITY_TYPE, MODEL_TYPE, DAO_TYPE>> {
}
