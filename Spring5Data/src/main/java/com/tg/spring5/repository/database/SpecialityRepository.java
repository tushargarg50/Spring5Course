package com.tg.spring5.repository.database;

import com.tg.spring5.model.Speciality;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jpa")
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
