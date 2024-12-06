package com.oris_first_semestr_work;

import com.oris_first_semestr_work.config.CustomDataSource;
import com.oris_first_semestr_work.config.JdbcTemplate;
import com.oris_first_semestr_work.repository.PetRepository;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new CustomDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        PetRepository petRepository = new PetRepository(jdbcTemplate);
        PetRepository orderRepository = new PetRepository(jdbcTemplate);
    }
}
