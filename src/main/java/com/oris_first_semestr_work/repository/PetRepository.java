package com.oris_first_semestr_work.repository;

import com.oris_first_semestr_work.config.JdbcTemplate;
import com.oris_first_semestr_work.entity.Pet;
import com.oris_first_semestr_work.mapper.impl.PetCreateParamMapper;
import com.oris_first_semestr_work.mapper.impl.PetDeleteParamMapper;
import com.oris_first_semestr_work.mapper.impl.PetRowMapper;
import com.oris_first_semestr_work.mapper.impl.PetUpdateParamMapper;
import com.oris_first_semestr_work.repository.impl.CrudRepositoryImpl;

public class PetRepository extends CrudRepositoryImpl<Pet, Integer> {
    public PetRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate,
                new PetRowMapper(),
                "select * from pets",
                "select * fromm pets where id = ?",
                "insert into pets(id, name) values (?, ?)",
                new PetCreateParamMapper(),
                "update pets set name = ? where id = ?",
                new PetUpdateParamMapper(),
                "delete from pets where id = ?",
                new PetDeleteParamMapper());
    }
}
