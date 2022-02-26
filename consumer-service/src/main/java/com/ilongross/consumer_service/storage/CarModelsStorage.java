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

    private static final Map<String, Map<Long, CarModel>> storageMap = new ConcurrentHashMap<>();
    private static final Map<Long, Object> extractedInfoMap = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong(0);

    public void addToStorage(CarModel carModel) {
        var id = counter.incrementAndGet();

        classifyModel(id, carModel.getBrand());

        if(storageMap.containsKey(carModel.getBrand())) {
            storageMap.get(carModel.getBrand()).put(id, carModel);
        }
        else {
            var innerMap = new HashMap<Long, CarModel>();
            innerMap.put(id, carModel);
            storageMap.put(carModel.getBrand(), innerMap);
        }

        log.info("CONSUMER: Added to storageMap CAR MODEL: id={} {}", id, carModel);
        log.info("CAR STORAGE size: {}", counter.get());

    }

    private void classifyModel(Long id, String brand) {
        CarModelClassify model = null;
        switch (brand) {
            case "Tesla":
                model = TeslaModel.builder().logo("TESLA_LOGO").build();
                break;
            case "Jeep":
                model = JeepModel.builder().isSUV(new Random().nextBoolean()).build();
                break;
            case "KIA":
                model = KiaModel.builder().isTaxi(new Random().nextBoolean()).driverName("SOME_DRIVER").build();
                break;
        }
        extractedInfoMap.put(id, model);
        log.info("CONSUMER: Added to extractedInfoMap CAR MODEL: {}", model);

    }

}
