package com.oris_first_semestr_work.repository.impl;

import com.oris_first_semestr_work.entity.FormUser;
import com.oris_first_semestr_work.repository.FormUserRepository;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FormUserRepositoryImpl implements FormUserRepository {
    private static final String FIND_ALL = """
    select u.id, p.full_name, p.phone_number from "user" u
    inner join profile p on u.id = p.user_id
    """;
    private String jdbcUrl;
    private String username;
    private String password;

    @Override
    public List<FormUser> findAll() throws SQLException, IOException, ClassNotFoundException {
        init();
        Class.forName("org.postgresql.Driver");
        Connection connection  = DriverManager.getConnection(jdbcUrl, username, password);
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(FIND_ALL);
        List<FormUser> users = new ArrayList<>();
        while (results.next()) {
            FormUser user = FormUser.builder()
                    .id(results.getInt("id"))
                    .fullName(results.getString("full_name"))
                    .phoneNumber(results.getString("phone_number"))
                    .build();
            users.add(user);
        }
        return users;
    }

    private void init() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties")) {
            properties.load(input);
        }
        jdbcUrl = properties.getProperty("jdbc-url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }
}
