package com.utopia.tracalculator.service;

/**
 * Created by fjoseph1313 on 12/18/2016.
 */

public enum EngineCapacity {
    SMALLER("500cc - 1000cc"),
    SMALL("1001cc - 1500cc"),
    MEDIUM("1501cc - 2000cc"),
    BIG("2001cc - 2500cc"),
    BIGGER("Above 2500cc");

    private String value;

    EngineCapacity(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
