package com.travelExpensor.entry;

import java.util.List;
import java.util.UUID;

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
public class Entry {

    private UUID id;
    private String title;
    private Float cost;
    private List<User> participants;
    private String currency;
    private User paidBy;
}
