package com.ilongross.consumer_service.service;

import com.ilongross.consumer_service.model.CarModel;
import com.ilongross.consumer_service.storage.CarModelsStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {

    @Autowired
    private CarModelsStorage carModelsStorage;

    @KafkaListener(topics = "car_models", groupId = "car_models_1")
    public void consume(CarModel carModel) {
        carModelsStorage.addToStorage(carModel);
    }

}
