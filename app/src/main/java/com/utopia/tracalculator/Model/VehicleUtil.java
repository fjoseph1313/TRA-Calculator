package com.utopia.tracalculator.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fjoseph1313 on 12/19/2016.
 */

public class VehicleUtil {

    private List<VehicleMake> vehicleMakes = new ArrayList<>(Arrays.asList(new VehicleMake("AUDI")));
    private List<VehicleModel> audiModels = Arrays.asList(new VehicleModel("A3 - HATCHBACK"), new VehicleModel("A3 - SEDAN"),new VehicleModel(""),
            new VehicleModel("A4 - WAGON"),new VehicleModel("A4 - SEDAN"),new VehicleModel("A4 ALLROAD QUATTRO - WAGON"),
            new VehicleModel("A4 TURBO QUATTRO - WAGON"),new VehicleModel("A4 TURBO QUATTRO - SEDAN"),new VehicleModel("A5 - HATCHBACK"),new VehicleModel("A5 - SEDAN"),new VehicleModel("A6 - SEDAN"),
            new VehicleModel("A6 - WAGON"),new VehicleModel("A6 ALLROAD QUATTRO - WAGON"),new VehicleModel("A7 - HATCHBACK"),
            new VehicleModel("A7 - SEDAN"),new VehicleModel("A8 - SEDAN"),new VehicleModel("A8 - WAGON"),new VehicleModel("Q3 - SUV"),new VehicleModel("Q5 - SUV"),new VehicleModel("Q7 - SUV"));
    private List<VehicleModel> alphaModels = Arrays.asList(new VehicleModel("145 - HATCHBACK"),new VehicleModel("145 - SEDAN"),new VehicleModel("147 - HATCHBACK"),new VehicleModel("147 - SEDAN"),
            new VehicleModel("155 - HATCHBACK"),
            new VehicleModel("155 - SEDAN"),new VehicleModel("156 - HATCHBACK"),new VehicleModel("156 - SEDAN"),new VehicleModel("159 - HATCHBACK"),new VehicleModel("159 - SEDAN"),
            new VehicleModel("166 - HATCHBACK"), new VehicleModel("166 - SEDAN"));

    private List<Vehicle> vehicles = Arrays.asList(
            Vehicle.builder().withMake("AUDI").withModel("A3 - HATCHBACK").build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build(),
            Vehicle.builder().build()
    );


    public VehicleUtil(){
        vehicleMakes.get(0).setModels(audiModels);
        VehicleMake alpha_romeo = new VehicleMake("ALPHA ROMEO");
        alpha_romeo.setModels(alphaModels);
        vehicleMakes.add(alpha_romeo);
    }

    public List<String> findModels(String make){
        List<String> models = new ArrayList<>();
        Iterator<VehicleMake> iter = vehicleMakes.iterator();
        while(iter.hasNext()){
            VehicleMake vmake = iter.next();
            if(vmake.getMake().equalsIgnoreCase(make)){
                for (VehicleModel name : vmake.getModels()) {
                    models.add(name.getModel());
                }
            }
        }
        return models;
    }

    public List<String> getVehicleMakes(){
        List<String> makes = new ArrayList<>();
        for(VehicleMake m : vehicleMakes){
            makes.add(m.getMake());
        }
        return makes;
    }
}
