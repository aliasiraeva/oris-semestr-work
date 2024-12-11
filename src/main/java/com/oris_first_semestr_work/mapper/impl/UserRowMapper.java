package com.oris_first_semestr_work.mapper.impl;

import com.oris_first_semestr_work.mapper.RowMapper;
import com.oris_first_semestr_work.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public List<User> mapRow(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            users.add(User.builder()
                    .id(resultSet.getInt("id"))
                    .username(resultSet.getString("username"))
                    .password(resultSet.getString("password"))
                    .build());
        }
        return users;
    }
}
