package com.mti.controller;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named
public class IndexController {
    public String hello() {
        return "Welcome Bus Company";
    }
}
