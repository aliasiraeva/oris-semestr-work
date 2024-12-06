package com.oris_first_semestr_work.mapper.impl;

import com.oris_first_semestr_work.entity.Pet;
import com.oris_first_semestr_work.entity.User;
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
                            .name(resultSet.getString("name"))
                            .type(resultSet.getString("type"))
                            .subType(resultSet.getString("sub_type"))
                            .build());
        }
        return objects;
    }
}
