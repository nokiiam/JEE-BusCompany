package com.mti.utils.setup;

import com.mti.controller.*;
import com.mti.controller.filter.RestCorsFilter;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@Singleton
@ApplicationPath("/api")
public class API extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return getRestResourceClasses();
    }

    private Set<Class<?>> getRestResourceClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(StopController.class);
        resources.add(RestCorsFilter.class);
        resources.add(LineController.class);
        resources.add(BusController.class);
        resources.add(DriverController.class);
        resources.add(LineStopController.class);
        resources.add(SlotController.class);
        resources.add(UserController.class);
        return resources;
    }
}
