package com.tg.spring5.repository.map;

import com.tg.spring5.model.Owner;
import com.tg.spring5.repository.database.OwnerRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("default")
public class OwnerMapRepository extends MapRepository<Owner, Long> implements OwnerRepository {
}
