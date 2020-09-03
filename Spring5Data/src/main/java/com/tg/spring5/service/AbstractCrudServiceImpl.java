package com.tg.spring5.service;

import com.tg.spring5.model.BaseEntity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCrudServiceImpl<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

    private Map<Long, T> map = new HashMap<>();

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T object) {
        map.put(object.getId(), object);
        System.out.println(this.getClass().getName() + ", Map Size : " + map.size());
        return object;
    }

    @Override
    public boolean delete(T object) {
        return map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public Collection<T> findAll() {
        return map.values();
    }
}
