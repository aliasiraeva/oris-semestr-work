
package com.oris_first_semestr_work.repository;

import com.oris_first_semestr_work.config.JdbcTemplate;
import com.oris_first_semestr_work.entity.Order;
import com.oris_first_semestr_work.mapper.impl.*;
import com.oris_first_semestr_work.repository.impl.CrudRepositoryImpl;

public class OrderRepository extends CrudRepositoryImpl<Order, Integer> {
    public OrderRepository(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate,
                new OrderRowMapper(),
                "select * from orders",
                "select * fromm orders where id = ?",
                "insert into orders(id, date, client_id, booking_id) values (?, ?)",
                new OrderCreateParamMapper(),
                "update orders set date=?, client_id=?, booking_id=? where id = ?",
                new OrderUpdateParamMapper(),
                "delete from orders where id = ?",
                new OrderDeleteParamMapper());
    }
}
