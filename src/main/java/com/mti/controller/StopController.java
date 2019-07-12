package com.mti.controller;

import com.mti.controller.data.StopRequest;
import com.mti.controller.data.StopResponse;
import com.mti.model.dao.StopDao;
import com.mti.model.data.StopModel;
import com.mti.service.StopService;
import com.mti.service.data.StopEntity;

public class StopController implements Controller<StopRequest, StopResponse, StopEntity, StopModel, StopDao, StopService> {
}
