package com.oris_first_semestr_work.mapper.impl;

import com.oris_first_semestr_work.entity.Order;
import com.oris_first_semestr_work.mapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public List<Order> mapRow(ResultSet resultSet) throws SQLException {
        List<Order> objects = new ArrayList<>();
        while (resultSet.next()) {
            objects.add(
                    Order.builder()
                            .id(resultSet.getInt("id"))
                            .date(resultSet.getObject("date", LocalDateTime.class))
                            .clientId(resultSet.getInt("client_id"))
                            .bookingId(resultSet.getInt("booking_id"))
                            .build());
        }
        return objects;
    }
}
