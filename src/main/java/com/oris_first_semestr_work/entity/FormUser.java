package com.oris_first_semestr_work.entity;

import lombok.*;

@Data
@Builder
public class FormUser {
    private int id;
    private String fullName;
    private String phoneNumber;
}
