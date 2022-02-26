package com.ilongross.consumer_service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KiaModel implements CarModelClassify {

    private boolean isTaxi;
    private String driverName;

}
