package com.tg.spring5.service.impl;

import com.tg.spring5.model.Vet;
import com.tg.spring5.service.AbstractCrudServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VetService extends AbstractCrudServiceImpl<Vet, Long> {

    private final Map<Long, Vet> map;

    public VetService() {
        map = new HashMap<>();
    }

    @Override
    public Map<Long, Vet> getMap() {
        return map;
    }

}
