package com.tg.spring5.service.impl;

import com.tg.spring5.model.Address;
import com.tg.spring5.model.Owner;
import com.tg.spring5.model.Pet;
import com.tg.spring5.repository.database.OwnerRepository;
import com.tg.spring5.service.AbstractCrudServiceMap;
import com.tg.spring5.service.CrudService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerService extends AbstractCrudServiceMap<Owner, Long> {

    private final CrudService<Address, Long> addressService;
    private final CrudService<Pet, Long> petService;

    private final OwnerRepository repository;

    public OwnerService(CrudService<Address, Long> addressService,
                        CrudService<Pet, Long> petService,
                        OwnerRepository repository) {
        this.addressService = addressService;
        this.petService = petService;
        this.repository = repository;
    }

    @Override
    public Optional<Owner> save(Owner object) {
        addressService.save(object.getAddress());
        object.getPets().forEach(petService::save);
        return super.save(object);
    }

    @Override
    protected CrudRepository<Owner, Long> getRepository() {
        return repository;
    }
}
