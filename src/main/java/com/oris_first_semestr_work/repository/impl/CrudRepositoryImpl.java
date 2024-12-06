package com.oris_first_semestr_work.repository.impl;

import com.oris_first_semestr_work.config.JdbcTemplate;
import com.oris_first_semestr_work.mapper.RowMapper;
import com.oris_first_semestr_work.mapper.ParamMapper;
import com.oris_first_semestr_work.repository.CrudRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CrudRepositoryImpl<T, ID> implements CrudRepository<T, ID> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<T> rowMapper;
    private final String findAllSql;
    private final String findByIdSql;
    private final String createSql;
    private final ParamMapper<T> createParamMapper;
    private final String updateSql;
    private final ParamMapper<T> updateParamMapper;
    private final String deleteSql;
    private final ParamMapper<T> deleteParamMapper;

    @Override
    public List<T> findAll() {
        return jdbcTemplate.execute(findAllSql, rowMapper);
    }

    @Override
    public Optional<T> findById(ID id) {
        List<T> entities = jdbcTemplate.execute(findByIdSql, rowMapper, id);
        if (entities.size() > 1) {
            throw new RuntimeException("Incorrect results size: " + entities.size());
        }
        return entities.stream().findAny();
    }

    @Override
    public void create(Object object) {
        jdbcTemplate.update(createSql, createParamMapper.mapParams(object));
    }

    @Override
    public void update(Object object) {
        jdbcTemplate.update(updateSql, updateParamMapper.mapParams(object));
    }

    @Override
    public void delete(Object object) {
        jdbcTemplate.update(deleteSql, deleteParamMapper.mapParams(object));
    }
}
