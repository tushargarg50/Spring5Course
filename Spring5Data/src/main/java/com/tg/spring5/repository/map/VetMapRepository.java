package com.tg.spring5.repository.map;

import com.tg.spring5.model.Vet;
import com.tg.spring5.repository.database.VetRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("default")
public class VetMapRepository extends MapRepository<Vet, Long> implements VetRepository {
}
