package com.oris_first_semestr_work.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Order {
    Integer id;
    LocalDateTime date;
    Integer clientId;
    Integer bookingId;
}
