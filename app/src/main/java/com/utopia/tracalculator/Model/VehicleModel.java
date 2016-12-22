package com.utopia.tracalculator.Model;

/**
 * Created by fjoseph1313 on 12/19/2016.
 */

public class VehicleModel {

    private Long id;
    private String model;
    private VehicleMake make;

    public VehicleModel(){}

    public VehicleModel(String model){
        this.model = model;
    }

    public VehicleModel(String model, VehicleMake make) {
        this.model = model;
        this.make = make;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VehicleMake getMake() {
        return make;
    }

    public void setMake(VehicleMake make) {
        this.make = make;
    }
}
