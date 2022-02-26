package com.ilongross.consumer_service;

import com.ilongross.consumer_service.storage.CarModelsStorage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerServiceApplicationTests {

    @Autowired
    private CarModelsStorage carModelsStorage;

    @Test
    void contextLoads() {
    }

    @Test
    void fillStorage() {
//        var carModel = CarModel.builder()
//                .brand("Tesla")
//                .modelName("Cybertruck")
//                .travelDistance(100000L)
//                .maxSpeed(300L)
//                .build();
//        for (int i = 0; i < 5; i++) {
//            try {
//                Thread.sleep(0);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            carModelsStorage.addToStorage(carModel);
//        }
    }


}
