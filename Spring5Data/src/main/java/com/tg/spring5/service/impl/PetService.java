package com.tg.spring5.service.impl;

import com.tg.spring5.model.Pet;
import com.tg.spring5.service.AbstractCrudServiceMapImpl;
import org.springframework.stereotype.Service;

@Service
public class PetService extends AbstractCrudServiceMapImpl<Pet, Long> {

}
