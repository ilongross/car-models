package com.ilongross.consumer_service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeslaModel implements CarModelClassified {

    private String logo;

}
