package com.travelExpensor.trip;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.travelExpensor.user.User;

@Repository
public class TripDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TripDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveTrip(Trip trip) {
        String sql = "insert into trips (tripid, name, date, outputcurrency) " +
                "values (?, ?, ?, ?)";
        List<Object[]> args = new ArrayList<>();
        args.add(new Object[]{
                trip.getId(),
                trip.getName(),
                new Timestamp(DateTime.now().getMillis()),
                trip.getOutputCurrency()
        });
        jdbcTemplate.batchUpdate(sql, args);
        saveTripParticipants(trip);
    }

    public Trip getTrip(UUID tripId) {
        String query = "SELECT * from trips t" +
                "  JOIN trip_participants tp" +
                "    on t.tripid = tp.tripid" +
                "  JOIN users u" +
                "    on u.userid = tp.userid" +
                "where t.tripid = ?";

        List<Object[]> args = new ArrayList<>();
        args.add(new Object[]{tripId});
//        Trip trip = jdbcTemplate.query(sql,
//                new Object[] { tripId },
//                (rs, rowNum) ->
//                    new Trip(
//                        (UUID) rs.getObject("t.id"),
//                        rs.getString("t.name"),
//                        (DateTime) rs.getObject("date"),
//                        rs.getString("outputcurrency"),
//                        ,
//                        Collections.emptyList()
//                    );
    }

    private void saveTripParticipants(Trip trip) {
        String sql = "insert into trip_participants (tripid, userid) " +
                "values (?, ?)";
        List<Object[]> args = new ArrayList<>();
        for (User user : trip.getParticipants()) {
            args.add(new Object[]{
                    trip.getId(),
                    user.getId()
            });
        }
        jdbcTemplate.batchUpdate(sql, args);
    }
}
