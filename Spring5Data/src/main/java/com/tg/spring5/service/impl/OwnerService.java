package com.tg.spring5.service.impl;

import com.tg.spring5.model.Address;
import com.tg.spring5.model.Owner;
import com.tg.spring5.model.Pet;
import com.tg.spring5.service.AbstractCrudServiceMap;
import com.tg.spring5.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class OwnerService extends AbstractCrudServiceMap<Owner, Long> {

    private final CrudService<Address, Long> addressService;
    private final CrudService<Pet, Long> petService;

    public OwnerService(CrudService<Address, Long> addressService, CrudService<Pet, Long> petService) {
        this.addressService = addressService;
        this.petService = petService;
    }

    @Override
    public Owner save(Owner object) {
        addressService.save(object.getAddress());
        object.getPets().forEach(petService::save);
        return super.save(object);
    }
}
