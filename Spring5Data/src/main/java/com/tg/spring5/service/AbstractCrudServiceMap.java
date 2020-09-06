package com.tg.spring5.service;

import com.tg.spring5.model.BaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class AbstractCrudServiceMap<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

    @Override
    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    public Optional<T> save(T object) {
        return Optional.of(getRepository().save(object));
    }

    @Override
    public void delete(T object) {
        getRepository().delete(object);
    }

    @Override
    public Iterable<T> findAll() {
        return getRepository().findAll();
    }

    protected abstract CrudRepository<T, ID> getRepository();
}
