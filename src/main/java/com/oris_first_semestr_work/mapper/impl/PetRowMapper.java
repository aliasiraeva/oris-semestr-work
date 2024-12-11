package com.oris_first_semestr_work.mapper.impl;

import com.oris_first_semestr_work.entity.Pet;
import com.oris_first_semestr_work.mapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetRowMapper implements RowMapper<Pet> {
    @Override
    public List<Pet> mapRow(ResultSet resultSet) throws SQLException {
        List<Pet> objects = new ArrayList<>();
        while (resultSet.next()) {
            objects.add(
                    Pet.builder()
                            .id(resultSet.getInt("id"))
                            .userId(resultSet.getInt("user_id"))
                            .name(resultSet.getString("name"))
                            .breed(resultSet.getString("breed"))
                            .build());
        }
        return objects;
    }
}
