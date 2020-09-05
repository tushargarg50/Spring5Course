package com.tg.spring5.bootstrap;

import com.tg.spring5.model.*;
import com.tg.spring5.service.CrudService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoaderMap implements CommandLineRunner {

    private final CrudService<Owner, Long> ownerService;
    private final CrudService<Vet, Long> vetService;
    private final CrudService<Pet, Long> petService;
    private final CrudService<Address, Long> addressService;
    private final CrudService<Speciality, Long> specialityService;

    public DataLoaderMap(CrudService<Owner, Long> ownerService, CrudService<Vet, Long> vetService, CrudService<Pet, Long> petService, CrudService<Address, Long> addressService, CrudService<Speciality, Long> specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.addressService = addressService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        Address address = new Address("ABC", "DEF", "GHI");
        Address address2 = new Address("JKL", "MNO", "PQR");
        Address address3 = new Address("STU", "VWX", "YZ");

        Pet pet = new Pet(PetType.DOG, "Kutta", LocalDate.now());
        Pet pet2 = new Pet(PetType.DOG, "Doggy", LocalDate.now());
        Pet pet3 = new Pet(PetType.CAT, "Billi", LocalDate.now());
        Pet pet4 = new Pet(PetType.CAT, "Pussy", LocalDate.now());

        Set<Pet> ownersPet = new HashSet<>();
        ownersPet.add(pet);
        ownersPet.add(pet2);

        Owner owner = new Owner("A", "A", address, ownersPet);
        ownerService.save(owner);

        ownersPet = new HashSet<>();
        ownersPet.add(pet3);

        owner = new Owner("B", "B", address2, ownersPet);
        ownerService.save(owner);

        ownersPet = new HashSet<>();
        ownersPet.add(pet4);

        owner = new Owner("C", "C", address3, ownersPet);
        ownerService.save(owner);

        Speciality speciality = new Speciality("Surgeon", "Surgeon");
        Speciality speciality2 = new Speciality("Dentist", "dentist");
        Speciality speciality3 = new Speciality("Check-up", "Check-Up");

        Set<Speciality> specialities = new HashSet<>();
        specialities.add(speciality);

        Vet vet = new Vet("A", "A", address3, specialities);
        vetService.save(vet);

        specialities = new HashSet<>();
        specialities.add(speciality2);

        vet = new Vet("B", "B", address2, specialities);
        vetService.save(vet);

        specialities = new HashSet<>();
        specialities.add(speciality3);

        vet = new Vet("C", "C", address, specialities);
        vetService.save(vet);

        specialityService.findAll();
        addressService.findAll();
        vetService.findAll();
        petService.findAll();
        ownerService.findAll();

    }
}
