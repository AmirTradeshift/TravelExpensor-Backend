package com.travelExpensor.trip;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class TripResource {

    private final TripService tripService;

    @Autowired
    public TripResource(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("trips/{tripId}")
    public Response getTrip(@PathVariable UUID tripId) {
        return Response.ok().build();
    }

    @GetMapping("trips")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrips() {
        List<String> list = new ArrayList<>();
        list.add("Amir");
        list.add("Sara");
        List<Trip> tripList = new ArrayList<>();
        tripList.add(tripService.createMockTrip(TripDTO.builder().name("trip1").outputCurrency("EUR").participants(list).build(), UUID.fromString("68983bc0-72fe-4fcd-876f-93f5cc955500")));
        tripList.add(tripService.createMockTrip(TripDTO.builder().name("trip2").outputCurrency("DKK").participants(list).build(), UUID.fromString("78aaf14b-4115-4b52-8aa9-9098729fa4e8")));
        TripResponseDTO tripResponseDTO = new TripResponseDTO(tripList);
        return Response.ok().entity(tripResponseDTO).build();
    }

    @PostMapping("trips")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveTrip(@RequestBody TripDTO tripDTO) {
        return Response.ok(tripService.createTrip(tripDTO)).build();
    }
}
