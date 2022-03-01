package com.ilongross.consumer_service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JeepModel implements CarModelClassified {

    private boolean isSUV;

}
