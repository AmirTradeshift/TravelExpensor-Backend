package com.travelExpensor.trip;

import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;

import com.travelExpensor.entry.Entry;
import com.travelExpensor.user.User;
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
public class Trip {

    private UUID id;
    private String name;
    private DateTime date;
    private String outputCurrency;
    private List<User> participants;
    private List<Entry> entries;
}
