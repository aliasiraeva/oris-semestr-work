package com.oris_first_semestr_work.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Pet {
    Integer id;
    Integer userId;
    String name;
    String breed;
}
