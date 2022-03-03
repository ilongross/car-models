package com.ilongross.producer_service;

import com.ilongross.producer_service.model.CarModel;
import com.ilongross.producer_service.util.ModelGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Random;

@SpringBootTest
@Slf4j
class ProducerServiceApplicationTests {

    @Autowired
    private ModelGenerator modelGenerator;

    @Test
    void contextLoads() {
    }

    @Test
    void carModel() {
        var carModel = CarModel.builder()
                .brand("Tesla")
                .modelName("Y")
                .travelDistance(50000L)
                .maxSpeed(260L)
                .build();
        log.info("CAR MODEL: {}", carModel);
    }

    @Test
    void modelGenerator() {
        for (int i = 0; i < 5; i++) {
            log.info("CAR MODEL: {}", modelGenerator.carModel());
        }
    }

    @Test
    void parseBrandsInValueAnnotation() {
        log.info("Brands: {}", Arrays.toString(modelGenerator.brands));
    }




}
