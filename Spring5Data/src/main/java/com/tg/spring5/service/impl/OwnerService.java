package com.tg.spring5.service.impl;

import com.tg.spring5.model.Owner;
import com.tg.spring5.service.AbstractCrudServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OwnerService extends AbstractCrudServiceImpl<Owner, Long> {

    private final Map<Long, Owner> map;

    public OwnerService() {
        map = new HashMap<>();
    }

    @Override
    public Map<Long, Owner> getMap() {
        return map;
    }
}
