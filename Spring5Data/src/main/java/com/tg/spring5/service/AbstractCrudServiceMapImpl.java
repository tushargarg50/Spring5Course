package com.tg.spring5.service;

import com.tg.spring5.model.BaseEntity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCrudServiceMapImpl<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

    private Map<ID, T> map = new HashMap<>();

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T object) {
        if (map.containsValue(object))
            return map.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(object))
                    .findFirst()
                    .map(Map.Entry::getValue).get();
        ID id = (ID) (object.getId() == null || object.getId() == 0L ? object.getNextId() : object.getId());
        object.setId(id);
        map.put(id, object);
        return object;
    }

    @Override
    public boolean delete(T object) {
        return map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public Collection<T> findAll() {
        map.entrySet().forEach(entry -> System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue()));
        return map.values();
    }
}
