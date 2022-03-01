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
        var rand = new Random();
        return CarModel.builder()
                .brand(brand)
                .modelName(getModel(brand))
                .travelDistance(rand.nextInt(100000 - 30000) + 30000L)
                .maxSpeed(rand.nextInt(300 - 200) + 200L)
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


}