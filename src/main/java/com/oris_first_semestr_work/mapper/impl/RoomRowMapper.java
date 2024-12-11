package com.oris_first_semestr_work.mapper.impl;

import com.oris_first_semestr_work.entity.Room;
import com.oris_first_semestr_work.mapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomRowMapper implements RowMapper<Room> {

    @Override
    public List<Room> mapRow(ResultSet resultSet) throws SQLException {
        List<Room> rooms = new ArrayList<>();
        while (resultSet.next()) {
            rooms.add(Room.builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .building(resultSet.getString("building"))
                    .terms(resultSet.getString("terms"))
                    .build());
        }
        return rooms;
    }
}
