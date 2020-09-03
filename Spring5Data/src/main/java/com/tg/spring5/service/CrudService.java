package com.tg.spring5.service;

import java.util.Collection;

public interface CrudService<T, ID> {

    T findById(ID id);

    T save(T object);

    boolean delete(T object);

    Collection<T> findAll();

}
