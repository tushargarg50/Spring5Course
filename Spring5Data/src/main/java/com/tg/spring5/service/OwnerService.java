package com.tg.spring5.service;

import com.tg.spring5.model.Owner;
import com.tg.spring5.model.Pet;
import com.tg.spring5.model.Vet;

import java.util.List;

public interface OwnerService {

    Owner findById(Long id);

    Owner save(Owner pet);

    boolean delete(Owner pet);

    List<Owner> findAll();
}
