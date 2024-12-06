package com.oris_first_semestr_work.repository.impl;

import com.oris_first_semestr_work.entity.User;
import com.oris_first_semestr_work.repository.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<User> findAll() {
        return List.of();
    }
}
