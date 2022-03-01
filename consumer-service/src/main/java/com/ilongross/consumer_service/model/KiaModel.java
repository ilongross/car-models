package com.ilongross.consumer_service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KiaModel implements CarModelClassified {

    private boolean isTaxi;
    private String driverName;

}
