package com.mti.controller;

import com.mti.controller.data.Request;
import com.mti.controller.data.Response;
import com.mti.model.dao.Dao;
import com.mti.model.data.Model;
import com.mti.service.Service;
import com.mti.service.data.Entity;

interface Controller<REQUEST_TYPE extends Request, RESPONSE_TYPE extends Response, ENTITY_TYPE extends Entity, MODEL_TYPE extends Model,
        DAO_TYPE extends Dao<MODEL_TYPE>,
        SERVICE_TYPE extends Service<ENTITY_TYPE, MODEL_TYPE, DAO_TYPE>> {
}
