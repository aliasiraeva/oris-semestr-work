package com.oris_first_semestr_work.config;

import lombok.AllArgsConstructor;

import javax.sql.DataSource;
import java.util.Properties;


@AllArgsConstructor
public class DataSourceConfiguration {

    private Properties properties;

    public DataSource customDataSource() {
        CustomDataSource customDataSource = new CustomDataSource();

        customDataSource.setUrl(properties.getProperty("database.url"));
        customDataSource.setUsername(properties.getProperty("database.username"));
        customDataSource.setPassword(properties.getProperty("database.password"));

        return customDataSource;
    }
}
