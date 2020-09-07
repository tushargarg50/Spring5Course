package com.tg.spring5.service.impl;

import com.tg.spring5.model.Pet;
import com.tg.spring5.repository.database.PetRepository;
import com.tg.spring5.service.AbstractCrudServiceMap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService extends AbstractCrudServiceMap<Pet, Long> {

    private final PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }


    @Override
    protected CrudRepository<Pet, Long> getRepository() {
        return repository;
    }
}
