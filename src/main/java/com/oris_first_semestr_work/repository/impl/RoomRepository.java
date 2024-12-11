package com.oris_first_semestr_work.repository.impl;

import com.oris_first_semestr_work.config.JdbcTemplate;
import com.oris_first_semestr_work.entity.Room;
import com.oris_first_semestr_work.mapper.impl.RoomRowMapper;
import com.oris_first_semestr_work.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class RoomRepository implements CrudRepository<Room, Integer> {
    private final JdbcTemplate jdbcTemplate;
    private final RoomRowMapper roomRowMapper = new RoomRowMapper();
    private static final String FIND_ALL_SQL = "select * from room";
    private static final String FIND_BY_ID_SQL = "select * from room where id = ?";
    private static final String CREATE_SQL = "insert into room(name, building, terms) values (?, ?, ?)";
    private static final String UPDATE_SQL = "update room set name = ?, building = ?, terms = ? where id = ?";
    private static final String DELETE_SQL = "delete from room where id = ?";

    public RoomRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Room> findAll() {
        return jdbcTemplate.execute(FIND_ALL_SQL, roomRowMapper);
    }

    @Override
    public Optional<Room> findById(Integer id) {
        List<Room> entities = jdbcTemplate.execute(FIND_BY_ID_SQL, roomRowMapper, id);
        if (entities.size() > 1) {
            throw new RuntimeException("Incorrect results size: " + entities.size());
        }
        return entities.stream().findAny();
    }

    @Override
    public void create(Room room) {
        jdbcTemplate.update(CREATE_SQL, room.getName(), room.getBuilding(), room.getTerms());
    }

    @Override
    public void update(Room room) {
        jdbcTemplate.update(UPDATE_SQL, room.getName(), room.getBuilding(), room.getTerms(), room.getId());
    }

    @Override
    public void delete(Room room) {
        jdbcTemplate.update(DELETE_SQL, room.getId());
    }
}
