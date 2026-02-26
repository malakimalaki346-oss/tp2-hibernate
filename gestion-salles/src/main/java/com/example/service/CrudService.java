package com.example.service;

import java.util.List;

public interface CrudService<T, ID> {

    void create(T entity);

    T findById(ID id);

    List<T> findAll();

    T update(T entity);

    void delete(ID id);
}