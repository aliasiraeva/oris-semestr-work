package com.oris_first_semestr_work.repository;

import com.oris_first_semestr_work.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
}
