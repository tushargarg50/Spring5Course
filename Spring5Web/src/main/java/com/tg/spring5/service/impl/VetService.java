package com.tg.spring5.service.impl;

import com.tg.spring5.model.Address;
import com.tg.spring5.model.Speciality;
import com.tg.spring5.model.Vet;
import com.tg.spring5.repository.database.VetRepository;
import com.tg.spring5.service.AbstractCrudServiceMap;
import com.tg.spring5.service.CrudService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VetService extends AbstractCrudServiceMap<Vet, Long> {

    private final CrudService<Speciality, Long> specialityService;
    private final CrudService<Address, Long> addressService;

    private final VetRepository repository;

    public VetService(CrudService<Speciality, Long> specialityService,
                      CrudService<Address, Long> addressService,
                      VetRepository repository) {
        this.specialityService = specialityService;
        this.addressService = addressService;
        this.repository = repository;
    }

    @Override
    public Optional<Vet> save(Vet object) {
        if (object.getAddress() != null) {
            addressService.save(object.getAddress());
        }
        object.getSpecialities().forEach(specialityService::save);
        return super.save(object);
    }

    @Override
    protected CrudRepository<Vet, Long> getRepository() {
        return repository;
    }
}
