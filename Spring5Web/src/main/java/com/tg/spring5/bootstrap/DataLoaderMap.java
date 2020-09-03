package com.tg.spring5.bootstrap;

import com.tg.spring5.model.Owner;
import com.tg.spring5.model.Vet;
import com.tg.spring5.service.CrudService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderMap implements CommandLineRunner {

    private final CrudService<Owner, Long> ownerService;
    private final CrudService<Vet, Long> vetService;

    public DataLoaderMap(CrudService<Owner, Long> ownerService, CrudService<Vet, Long> vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("A");
        owner.setLastName("A");

        ownerService.save(owner);

        owner = new Owner();
        owner.setId(2L);
        owner.setFirstName("B");
        owner.setLastName("B");

        ownerService.save(owner);

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("C");
        vet.setLastName("C");

        vetService.save(vet);

        vet = new Vet();
        vet.setId(2L);
        vet.setFirstName("D");
        vet.setLastName("D");

        vetService.save(vet);
    }
}
