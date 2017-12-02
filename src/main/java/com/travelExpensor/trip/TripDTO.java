package com.travelExpensor.trip;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("participants")
    private List<String> participants;

    @JsonProperty("outputCurrency")
    private String outputCurrency;
}
