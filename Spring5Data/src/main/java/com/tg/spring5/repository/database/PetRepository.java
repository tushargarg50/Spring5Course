package com.tg.spring5.repository.database;

import com.tg.spring5.model.Pet;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jpa")
public interface PetRepository extends CrudRepository<Pet, Long> {
}
