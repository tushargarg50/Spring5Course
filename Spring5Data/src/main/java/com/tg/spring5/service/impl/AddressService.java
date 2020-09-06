package com.tg.spring5.service.impl;

import com.tg.spring5.model.Address;
import com.tg.spring5.service.AbstractCrudServiceMap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends AbstractCrudServiceMap<Address, Long> {

    private final CrudRepository<Address, Long> repository;

    public AddressService(CrudRepository<Address, Long> repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<Address, Long> getRepository() {
        return repository;
    }
}
