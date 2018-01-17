package com.example.jonas.starwarproject.Vehicule;

import java.io.Serializable;

/**
 * Created by Jonas on 16/01/2018.
 */

public class Vehicule implements Serializable {


    private String name;
    private String model;
    private String manufacturer;
    private String cost_in_credits;
    private String crew;
    private String length;
    private String max_atmosphering_speed;
    private String passengers;
    private String cargo_capacity;
    private String consumables;
    private String vehicle_class;



    public String getCrew() {

        return crew;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }

    public String getLength() {
        return length;
    }

    public String getMax_atmosphering_speed() {
        return max_atmosphering_speed;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getCargo_capacity() {
        return cargo_capacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public String getVehicle_class() {
        return vehicle_class;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCost_in_credits(String cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setMax_atmosphering_speed(String max_atmosphering_speed) {
        this.max_atmosphering_speed = max_atmosphering_speed;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public void setCargo_capacity(String cargo_capacity) {
        this.cargo_capacity = cargo_capacity;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public void setVehicle_class(String vehicle_class) {
        this.vehicle_class = vehicle_class;
    }
}
