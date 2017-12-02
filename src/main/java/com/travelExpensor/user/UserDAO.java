package com.travelExpensor.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveUsers(List<User> users) {
        String sql = "insert into users (userid, name, balance) " +
                "values (?, ?, ?)";

        for (User user : users) {
            List<Object[]> args = new ArrayList<>();
            args.add(new Object[]{
                    user.getId(),
                    user.getName(),
                    user.getBalance()
            });
            jdbcTemplate.batchUpdate(sql, args);
        }
    }
}
