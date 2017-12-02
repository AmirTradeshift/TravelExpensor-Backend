package com.travelExpensor.trip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelExpensor.user.User;
import com.travelExpensor.user.UserDAO;

@Service
public class TripService {

    private TripDAO tripDAO;
    private UserDAO userDAO;

    @Autowired
    public TripService(TripDAO tripDAO, UserDAO userDAO) {
        this.tripDAO = tripDAO;
        this.userDAO = userDAO;
    }

    public UUID createTrip(TripDTO tripDTO) {
        List<User> userList = new ArrayList<>();
        for (String name : tripDTO.getParticipants()) {
            User user = new User(UUID.randomUUID(), name, Float.intBitsToFloat(0));
            userList.add(user);
        }
        Trip trip = new Trip(
                UUID.randomUUID(),
                tripDTO.getName(),
                null,
                tripDTO.getOutputCurrency(),
                userList,
                Collections.emptyList());
        tripDAO.saveTrip(trip);
        userDAO.saveUsers(userList);
        return trip.getId();
    }

    public Trip createMockTrip(TripDTO tripDTO, UUID id) {
        List<User> userList = new ArrayList<>();
        for (String name : tripDTO.getParticipants()) {
            User user = new User(UUID.randomUUID(), name, Float.intBitsToFloat(0));
            userList.add(user);
        }
        Trip trip = new Trip(
                id,
                tripDTO.getName(),
                null,
                tripDTO.getOutputCurrency(),
                userList,
                Collections.emptyList());
        return trip;
    }
}
