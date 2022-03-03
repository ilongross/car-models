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

    @Value("#{'${brands}'.split(',')}")
    public String[] brands;

    @Value("#{'${models.tesla}'.split(',')}")
    private String[] teslaModels;
    @Value("#{'${models.jeep}'.split(',')}")
    private String[] jeepModels;
    @Value("#{'${models.kia}'.split(',')}")
    private String[] kiaModels;

    @SneakyThrows
    public CarModel carModel() {
        Thread.sleep(delay);

        var brand = getRandom(brands);
        return CarModel.builder()
                .brand(brand)
                .modelName(getModel(brand))
                .travelDistance(getRandomLong(30000, 100000))
                .maxSpeed(getRandomLong(200, 300))
                .build();
    }

    private String getModel(String brand) {
        return switch (brand) {
            case "Tesla" -> getRandom(teslaModels);
            case "Jeep" -> getRandom(jeepModels);
            case "KIA" -> getRandom(kiaModels);
            default -> "";
        };
    }

    private String getRandom(String[] array) {
        return array[new Random().nextInt(array.length)];
    }

    private Long getRandomLong(int min, int max) {
        return (long) (new Random().nextInt(max - min) + min);
    }

}