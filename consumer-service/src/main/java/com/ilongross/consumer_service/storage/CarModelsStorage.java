package com.ilongross.consumer_service.storage;

import com.ilongross.consumer_service.model.CarModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Slf4j
public class CarModelsStorage {

    private static Map<String, Map<Long, CarModel>> storage = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong(0);

    public void addToStorage(CarModel carModel) {
        var id = counter.incrementAndGet();

        if(storage.containsKey(carModel.getBrand())) {
            storage.get(carModel.getBrand()).put(id, carModel);
        }
        else {
            var innerMap = new HashMap<Long, CarModel>();
            innerMap.put(id, carModel);
            storage.put(carModel.getBrand(), innerMap);
        }

        log.info("CONSUMER: Added to storage CAR MODEL: id={} {}", id, carModel);
        log.info("CAR STORAGE size: {}", counter.get());

    }

}
