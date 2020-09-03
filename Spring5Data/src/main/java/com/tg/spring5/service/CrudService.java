package com.tg.spring5.service;

import com.tg.spring5.model.Owner;

import java.util.List;

public interface CrudService<T, ID> {

    T findById(ID id);

    T save(T pet);

    boolean delete(T pet);

    List<T> findAll();

}
