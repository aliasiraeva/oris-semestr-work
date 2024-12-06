package com.oris_first_semestr_work.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Pet {
    Integer id;
    String name;
    String type;
    String subType;
}
