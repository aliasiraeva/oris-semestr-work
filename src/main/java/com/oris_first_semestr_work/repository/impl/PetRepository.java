package com.oris_first_semestr_work.repository.impl;

import com.oris_first_semestr_work.config.JdbcTemplate;
import com.oris_first_semestr_work.entity.Pet;
import com.oris_first_semestr_work.mapper.impl.*;
import com.oris_first_semestr_work.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class PetRepository implements CrudRepository<Pet, Integer> {
    private final JdbcTemplate jdbcTemplate;
    private final PetRowMapper petRowMapper = new PetRowMapper();
    private static final String FIND_ALL_SQL = "select * from pet";
    private static final String FIND_BY_ID_SQL = "select * from pet where id = ?";
    private static final String CREATE_SQL = "insert into pet(user_id, name, breed) values (?, ?, ?)";
    private static final String UPDATE_SQL = "update pet set user_id = ?, name = ?, breed = ? where id = ?";
    private static final String DELETE_SQL = "delete from pet where id = ?";

    public PetRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pet> findAll() {
        return jdbcTemplate.execute(FIND_ALL_SQL, petRowMapper);
    }

    @Override
    public Optional<Pet> findById(Integer id) {
        List<Pet> entities = jdbcTemplate.execute(FIND_BY_ID_SQL, petRowMapper, id);
        if (entities.size() > 1) {
            throw new RuntimeException("Incorrect results size: " + entities.size());
        }
        return entities.stream().findAny();
    }

    @Override
    public void create(Pet pet) {
        jdbcTemplate.update(CREATE_SQL, pet.getUserId(), pet.getName(), pet.getBreed());
    }

    @Override
    public void update(Pet pet) {
        jdbcTemplate.update(UPDATE_SQL, pet.getUserId(), pet.getName(), pet.getBreed(), pet.getId());
    }

    @Override
    public void delete(Pet pet) {
        jdbcTemplate.update(DELETE_SQL, pet.getId());
    }
}


