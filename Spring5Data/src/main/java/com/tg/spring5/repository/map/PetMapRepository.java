package com.tg.spring5.repository.map;

import com.tg.spring5.model.Pet;
import com.tg.spring5.repository.database.PetRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("default")
public class PetMapRepository extends MapRepository<Pet, Long> implements PetRepository {
}
