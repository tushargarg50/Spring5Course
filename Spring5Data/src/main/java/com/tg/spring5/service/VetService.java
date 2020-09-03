package com.tg.spring5.service;

import com.tg.spring5.model.Owner;
import com.tg.spring5.model.Vet;

import java.util.List;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet pet);

    boolean delete(Vet pet);

    List<Vet> findAll();
}
