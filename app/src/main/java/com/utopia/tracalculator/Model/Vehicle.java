package com.utopia.tracalculator.Model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by fjoseph1313 on 12/17/2016.
 */

public class Vehicle implements Serializable{

    private Long id;
    private String make;
    private String model;
    private VehicleMake vehicleMake;
    private Long yearOfManufacture;
    private String fuel;
    private String engineCapacity;
    private BigDecimal currentRetailPrice;
    private String driveConfiguration;
    private VehicleCategory vehicleCategory;

    public Vehicle(Builder builder){
        setId(builder.id);
        setMake(builder.make);
        setModel(builder.model);
        setYearOfManufacture(builder.yearOfManufacture);
        setFuel(builder.fuel);
        setEngineCapacity(builder.engineCapacity);
        setCurrentRetailPrice(builder.currentRetailPrice);
        setDriveConfiguration(builder.driveConfiguration);
        setVehicleCategory(builder.vehicleCategory);
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Long yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public BigDecimal getCurrentRetailPrice() {
        return currentRetailPrice;
    }

    public void setCurrentRetailPrice(BigDecimal currentRetailPrice) {
        this.currentRetailPrice = currentRetailPrice;
    }

    public String getDriveConfiguration() {
        return driveConfiguration;
    }

    public void setDriveConfiguration(String driveConfiguration) {
        this.driveConfiguration = driveConfiguration;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public Builder copyBuilder(){
        return new Builder(this);
    }

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String make;
        private String model;
        private Long yearOfManufacture;
        private String fuel;
        private String engineCapacity;
        private BigDecimal currentRetailPrice;
        private String driveConfiguration;
        private VehicleCategory vehicleCategory;

        public Builder(){}

        public Builder(Vehicle vehicle){
            id = vehicle.id;
            make = vehicle.make;
            model = vehicle.model;
            yearOfManufacture = vehicle.yearOfManufacture;
            fuel = vehicle.fuel;
            engineCapacity = vehicle.engineCapacity;
            currentRetailPrice = vehicle.currentRetailPrice;
            driveConfiguration = vehicle.driveConfiguration;
            vehicleCategory = vehicle.vehicleCategory;
        }

        public Builder withId(Long id){
            this.id = id;
            return this;
        }

        public Builder withMake(String make){
            this.make = make;
            return this;
        }

        public Builder withModel(String model){
            this.model = model;
            return this;
        }

        public Builder withYearOfManufacture(Long year){
            this.yearOfManufacture = year;
            return this;
        }

        public Builder withFuel(String fuel){
            this.fuel = fuel;
            return this;
        }

        public Builder withEngineCapacity(String capacity){
            this.engineCapacity = capacity;
            return this;
        }

        public Builder withCurrentRetailPrice(BigDecimal price){
            this.currentRetailPrice = price;
            return this;
        }

        public Builder withDriveConfiguration(String config){
            this.driveConfiguration = config;
            return this;
        }

        public Builder withVehicleCategory(VehicleCategory category){
            this.vehicleCategory = category;
            return this;
        }

        public Vehicle build(){
            return new Vehicle(this);
        }
    }

}
