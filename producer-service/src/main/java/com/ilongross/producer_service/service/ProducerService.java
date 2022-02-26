package com.ilongross.producer_service.service;

import com.ilongross.producer_service.model.CarModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, CarModel> kafkaTemplate;

    public void produce(CarModel carModel) {
        kafkaTemplate.send("car_models", carModel);
        log.info("PRODUCER: sent CAR MODEL: {}", carModel);
    }


}
