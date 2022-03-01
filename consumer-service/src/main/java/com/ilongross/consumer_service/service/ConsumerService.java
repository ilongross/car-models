package com.ilongross.consumer_service.service;

import com.ilongross.consumer_service.model.CarModel;
import com.ilongross.consumer_service.storage.CarModelsStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {

    private final CarModelsStorage carModelsStorage;

    @KafkaListener(topics = "car_models", groupId = "car_models_1")
    public void consume(CarModel carModel) {
        carModelsStorage.addToStorage(carModel);
    }

}
