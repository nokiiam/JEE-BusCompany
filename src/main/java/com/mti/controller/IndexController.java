package com.mti.controller;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named("indexController")
public class IndexController {
    public String helllo() {
        return "Xylophone";
    }
}
