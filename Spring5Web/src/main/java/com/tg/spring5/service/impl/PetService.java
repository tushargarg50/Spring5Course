package com.tg.spring5.service.impl;

import com.tg.spring5.model.Pet;
import com.tg.spring5.service.AbstractCrudServiceMap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService extends AbstractCrudServiceMap<Pet, Long> {

    private final CrudRepository<Pet, Long> repository;

    public PetService(CrudRepository<Pet, Long> repository) {
        this.repository = repository;
    }


    @Override
    protected CrudRepository<Pet, Long> getRepository() {
        return repository;
    }
}
