package com.travelExpensor;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelExpensorController {

    @GetMapping("trips/{tripId}")
    public Response getTrip(@PathVariable String tripId) {
        TripDTO tripDTO = new TripDTO("myTripName", tripId, "EUR");
        return Response.ok(tripDTO).build();
    }
}
