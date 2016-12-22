package com.utopia.tracalculator.Model;

import java.util.List;

/**
 * Created by fjoseph1313 on 12/19/2016.
 */

public class VehicleMake {

    private Long id;
    private String make;
    private List<VehicleModel> models;

    public VehicleMake(String make) {
        this.make = make;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public List<VehicleModel> getModels() {
        return models;
    }

    public void setModels(List<VehicleModel> models) {
        this.models = models;
    }
}
