package com.utopia.tracalculator.Model;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by fjoseph1313 on 12/17/2016.
 */

public class VehicleCategory implements Serializable{

    private Long id;
    private String category;
    private Set<Vehicle> vehicles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
