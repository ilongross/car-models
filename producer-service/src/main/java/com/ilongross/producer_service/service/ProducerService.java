package com.ilongross.producer_service.service;

import com.ilongross.producer_service.model.CarModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProducerService {

    private final KafkaTemplate<String, CarModel> kafkaTemplate;

    public void produce(CarModel carModel) {
        kafkaTemplate.send("car_models", carModel);
        log.info("PRODUCER: sent CAR MODEL: {}", carModel);
    }


}
