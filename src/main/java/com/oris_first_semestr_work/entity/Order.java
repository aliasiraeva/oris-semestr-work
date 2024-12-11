package com.oris_first_semestr_work.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class Order {
    Integer id;
    LocalDateTime date;
    Integer userId;
    Integer bookingId;
}
