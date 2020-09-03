package com.tg.spring5.service.impl;

import com.tg.spring5.model.Pet;
import com.tg.spring5.service.AbstractCrudServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PetService extends AbstractCrudServiceImpl<Pet, Long> {

    private final Map<Long, Pet> map;

    public PetService() {
        map = new HashMap<>();
    }

    @Override
    public Map<Long, Pet> getMap() {
        return map;
    }
}
