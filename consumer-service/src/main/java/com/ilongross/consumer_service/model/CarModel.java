package com.ilongross.consumer_service.model;

public class CarModel {

    public String brand;
    public String modelName;
    public Long travelDistance;
    public Long maxSpeed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Long getTravelDistance() {
        return travelDistance;
    }

    public void setTravelDistance(Long travelDistance) {
        this.travelDistance = travelDistance;
    }

    public Long getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "brand='" + brand + '\'' +
                ", modelName='" + modelName + '\'' +
                ", travelDistance=" + travelDistance +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}