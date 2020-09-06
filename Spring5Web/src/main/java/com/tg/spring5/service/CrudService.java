package com.tg.spring5.service;

import java.util.Optional;

public interface CrudService<T, ID> {

    Optional<T> findById(ID id);

    Optional<T> save(T object);

    void delete(T object);

    Iterable<T> findAll();

}
