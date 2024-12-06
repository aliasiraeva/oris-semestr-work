package com.oris_first_semestr_work.mapper.impl;

import com.oris_first_semestr_work.entity.Order;
import com.oris_first_semestr_work.mapper.ParamMapper;

public class OrderUpdateParamMapper implements ParamMapper<Order> {
    @Override
    public Object[] mapParams(Object object) {
        Order order = (Order) object;
        return new Object[] {order.getDate(), order.getClientId(), order.getBookingId(), order.getId()};
    }
}