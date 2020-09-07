package com.tg.spring5.repository.map;

import com.tg.spring5.model.Speciality;
import com.tg.spring5.repository.database.SpecialityRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("default")
public class SpecialityMapRepository extends MapRepository<Speciality, Long> implements SpecialityRepository {
}
