package com.travelExpensor;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class TripDTO {

    private String id;
    private String name;
    private String outputCurrency;

    public TripDTO(String tripName, String tripId, String outputCurrency) {
        this.id = tripId;
        this.name = tripName;
        this.outputCurrency = outputCurrency;
    }
}
