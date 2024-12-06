package com.oris_first_semestr_work.repository;

import com.oris_first_semestr_work.entity.FormUser;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface FormUserRepository {
    List<FormUser> findAll() throws SQLException, IOException, ClassNotFoundException;
}
