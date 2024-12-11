
package com.oris_first_semestr_work.repository.impl;

import com.oris_first_semestr_work.config.JdbcTemplate;
import com.oris_first_semestr_work.entity.Order;
import com.oris_first_semestr_work.mapper.impl.*;
import com.oris_first_semestr_work.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class OrderRepository implements CrudRepository<Order, Integer> {

    private final JdbcTemplate jdbcTemplate;
    private final OrderRowMapper orderRowMapper = new OrderRowMapper();
    private static final String FIND_ALL_SQL = "select * from \"order\"";
    private static final String FIND_BY_ID_SQL = "select * from \"order\" where id = ?";
    private static final String CREATE_SQL = "insert into \"order\"(date, user_id, booking_id) values (?, ?, ?)";
    private static final String UPDATE_SQL = "update \"order\" set date = ?, user_id = ?, booking_id = ? where id = ?";
    private static final String DELETE_SQL = "delete from \"order\" where id = ?";

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Order> findAll() {
        return jdbcTemplate.execute(FIND_ALL_SQL, orderRowMapper);
    }

    @Override
    public Optional<Order> findById(Integer id) {
        List<Order> entities = jdbcTemplate.execute(FIND_BY_ID_SQL, orderRowMapper, id);
        if (entities.size() > 1) {
            throw new RuntimeException("Incorrect results size: " + entities.size());
        }
        return entities.stream().findAny();
    }

    @Override
    public void create(Order order) {
        jdbcTemplate.update(CREATE_SQL, order.getDate(), order.getUserId(), order.getBookingId());
    }

    @Override
    public void update(Order order) {
        jdbcTemplate.update(UPDATE_SQL, order.getDate(), order.getUserId(), order.getBookingId(), order.getId());
    }

    @Override
    public void delete(Order order) {
        jdbcTemplate.update(DELETE_SQL, order.getId());
    }
}
