package com.tg.spring5.service;

import com.tg.spring5.service.CrudService;

import java.util.Collection;
import java.util.Map;

public abstract class AbstractCrudServiceImpl<T, ID> implements CrudService<T, ID> {

    public abstract Map<ID, T> getMap();

    @Override
    public T findById(ID id) {
        return getMap().get(id);
    }

    @Override
    public T save(ID id, T object) {
        getMap().put(id, object);
        return object;
    }

    @Override
    public boolean delete(T object) {
        return getMap().entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public Collection<T> findAll() {
        return getMap().values();
    }
}
