package com.oris_first_semestr_work.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    List<T> findAll();
    Optional<T> findById(ID id);
    void create(T object);
    void update(T object);
    void delete(T object);
}
