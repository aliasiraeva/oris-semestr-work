package com.oris_first_semestr_work.mapper.impl;

import com.oris_first_semestr_work.entity.Booking;
import com.oris_first_semestr_work.mapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingRowMapper implements RowMapper<Booking> {
    @Override
    public List<Booking> mapRow(ResultSet resultSet) throws SQLException {
        List<Booking> bookings = new ArrayList<>();
        while (resultSet.next()) {
            bookings.add(Booking.builder()
                    .id(resultSet.getInt("id"))
                    .petId(resultSet.getInt("pet_id"))
                    .roomId(resultSet.getInt("room_id"))
                    .start(resultSet.getObject("date", LocalDateTime.class))
                    .end(resultSet.getObject("date", LocalDateTime.class))
                    .build());
        }
        return bookings;
    }
}
