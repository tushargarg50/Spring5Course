package com.tg.spring5.service.impl;

import com.tg.spring5.model.Address;
import com.tg.spring5.model.Speciality;
import com.tg.spring5.model.Vet;
import com.tg.spring5.service.AbstractCrudServiceMap;
import com.tg.spring5.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class VetService extends AbstractCrudServiceMap<Vet, Long> {

    private final CrudService<Speciality, Long> specialityService;
    private final CrudService<Address, Long> addressService;

    public VetService(CrudService<Speciality, Long> specialityService,
                      CrudService<Address, Long> addressService) {
        this.specialityService = specialityService;
        this.addressService = addressService;
    }

    @Override
    public Vet save(Vet object) {
        if (object.getAddress() != null) {
            addressService.save(object.getAddress());
        }
        object.getSpecialities().forEach(specialityService::save);
        return super.save(object);
    }
}
