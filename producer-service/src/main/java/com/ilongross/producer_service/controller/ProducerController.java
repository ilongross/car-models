package com.ilongross.producer_service.controller;

import com.ilongross.producer_service.service.ProducerService;
import com.ilongross.producer_service.util.ModelGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private ProducerService producerService;
    @Autowired
    private ModelGenerator modelGenerator;

    @GetMapping("/send-model")
    public String sendModel() {
        producerService.produce(modelGenerator.carModel());
        return "Model SENT";
    }

}
