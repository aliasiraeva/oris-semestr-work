package com.oris_first_semestr_work.repository.impl;

import com.oris_first_semestr_work.config.JdbcTemplate;
import com.oris_first_semestr_work.entity.User;
import com.oris_first_semestr_work.mapper.impl.UserRowMapper;
import com.oris_first_semestr_work.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class UserRepository implements CrudRepository<User, Integer> {
    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper = new UserRowMapper();
    private static final String FIND_ALL_SQL = "select * from \"user\"";
    private static final String FIND_BY_ID_SQL = "select * from \"user\" where id = ?";
    private static final String CREATE_SQL = "insert into \"user\"(username, password) values (?, ?)";
    private static final String UPDATE_SQL = "update \"user\" set username = ?, password = ? where id = ?";
    private static final String DELETE_SQL = "delete from \"user\" where id = ?";

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.execute(FIND_ALL_SQL, userRowMapper);
    }

    @Override
    public Optional<User> findById(Integer id) {
        List<User> entities = jdbcTemplate.execute(FIND_BY_ID_SQL, userRowMapper, id);
        if (entities.size() > 1) {
            throw new RuntimeException("Incorrect results size: " + entities.size());
        }
        return entities.stream().findAny();
    }

    @Override
    public void create(User user) {
        jdbcTemplate.update(CREATE_SQL, user.getUsername(), user.getPassword());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update(UPDATE_SQL, user.getUsername(), user.getPassword(), user.getId());
    }

    @Override
    public void delete(User user) {
        jdbcTemplate.update(DELETE_SQL, user.getId());
    }
}
