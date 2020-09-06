package com.tg.spring5.service.impl;

import com.tg.spring5.model.Speciality;
import com.tg.spring5.service.AbstractCrudServiceMap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class SpecialityService extends AbstractCrudServiceMap<Speciality, Long> {

    private final CrudRepository<Speciality, Long> repository;

    public SpecialityService(CrudRepository<Speciality, Long> repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<Speciality, Long> getRepository() {
        return repository;
    }
}
