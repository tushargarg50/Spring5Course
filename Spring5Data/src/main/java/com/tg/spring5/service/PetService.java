package com.tg.spring5.service;

import com.tg.spring5.model.Owner;
import com.tg.spring5.model.Pet;

import java.util.List;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    boolean delete(Pet pet);

    List<Pet> findAll();

}
