package com.mti.controller;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named
public class IndexController {
    public String hello() {
        return "Xylophone";
    }

    public String user() {
        return "Prout";
    }
}
