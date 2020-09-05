package com.tg.spring5.service.impl;

import com.tg.spring5.model.Pet;
import com.tg.spring5.service.AbstractCrudServiceMap;
import org.springframework.stereotype.Service;

@Service
public class PetService extends AbstractCrudServiceMap<Pet, Long> {

}
