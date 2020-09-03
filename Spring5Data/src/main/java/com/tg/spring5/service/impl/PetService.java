package com.tg.spring5.service.impl;

import com.tg.spring5.model.Pet;
import com.tg.spring5.service.AbstractCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PetService extends AbstractCrudServiceImpl<Pet, Long> {

}
