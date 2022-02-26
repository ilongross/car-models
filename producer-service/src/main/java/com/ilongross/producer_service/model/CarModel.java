package com.ilongross.producer_service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarModel {

    public String brand;
    public String modelName;
    public Long travelDistance;
    public Long maxSpeed;

}