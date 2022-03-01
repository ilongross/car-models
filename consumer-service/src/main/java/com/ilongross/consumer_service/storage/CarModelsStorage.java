package com.ilongross.consumer_service.storage;

import com.ilongross.consumer_service.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Slf4j
public class CarModelsStorage {

    private static final Map<String, Map<Long, CarModel>> carModelsMap = new ConcurrentHashMap<>();
    private static final Map<Long, CarModelClassified> classifiedCarModelsMap = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong(0);

    public void addToStorage(CarModel carModel) {
        var id = counter.incrementAndGet();
        fillCarModelsMap(id, carModel);
        fillClassifiedCarModelsMap(id, carModel);
        carModelsStorageInfo();
    }

    private void fillCarModelsMap(Long id, CarModel carModel) {
        if(carModelsMap.containsKey(carModel.getBrand())) {
            carModelsMap.get(carModel.getBrand()).put(id, carModel);
        }
        else {
            var innerMap = new HashMap<Long, CarModel>();
            innerMap.put(id, carModel);
            carModelsMap.put(carModel.getBrand(), innerMap);
        }
        log.info("CONSUMER: Added to carModelsMap CAR MODEL: id={} {}", id, carModel);
    }

    private void fillClassifiedCarModelsMap(Long id, CarModel carModel) {
        var model = switch (carModel.getBrand()) {
            case "Tesla" -> TeslaModel.builder().logo("TESLA_LOGO").build();
            case "Jeep" -> JeepModel.builder().isSUV(new Random().nextBoolean()).build();
            case "KIA" -> KiaModel.builder().isTaxi(new Random().nextBoolean()).driverName("SOME_DRIVER").build();
            default -> null;
        };
        classifiedCarModelsMap.put(id, model);
        log.info("CONSUMER: Added to classifiedCarModelsMap CAR MODEL: {}", model);
    }

    private void carModelsStorageInfo() {
        log.info("CAR MODELS MAP size: {}", counter.get());
        for (var brand : carModelsMap.keySet()) {
            log.info("BRAND: {}; Size: {}", brand, carModelsMap.get(brand).size());
        }
    }

}
