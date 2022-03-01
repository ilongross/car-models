package com.ilongross.producer_service.controller;

import com.ilongross.producer_service.service.ProducerService;
import com.ilongross.producer_service.util.ModelGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService producerService;
    private final ModelGenerator modelGenerator;

    @GetMapping("/send-model")
    public String sendModel() {
        producerService.produce(modelGenerator.carModel());
        return "Model SENT";
    }

}
