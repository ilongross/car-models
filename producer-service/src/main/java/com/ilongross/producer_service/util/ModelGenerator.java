package com.ilongross.producer_service.util;

import com.ilongross.producer_service.model.CarModel;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ModelGenerator {

    @Value("${generator.delay}")
    private Integer delay;

    @Value("${brands}")
    private String brands;

    @Value("${models.tesla}")
    private String teslaModels;
    @Value("${models.jeep}")
    private String jeepModels;
    @Value("${models.kia}")
    private String kiaModels;

    @SneakyThrows
    public CarModel carModel() {
        Thread.sleep(delay);

        var brandsArray = brands.split(",");
        var brand = brandsArray[new Random().nextInt(brandsArray.length)];
        return CarModel.builder()
                .brand(brand)
                .modelName(getModel(brand))
                .travelDistance(getRandomLong(30000, 100000))
                .maxSpeed(getRandomLong(200, 300))
                .build();
    }

    private String getModel(String brand) {
        return switch (brand) {
            case "Tesla" -> parseModels(teslaModels);
            case "Jeep" -> parseModels(jeepModels);
            case "KIA" -> parseModels(kiaModels);
            default -> "";
        };
    }

    private String parseModels(String models) {
        var array = models.split(",");
        return array[new Random().nextInt(array.length)];
    }

    private Long getRandomLong(int min, int max) {
        return (long) (new Random().nextInt(max - min) + min);
    }

}