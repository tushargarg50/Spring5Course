package com.tg.spring5.repository.database;

import com.tg.spring5.model.Address;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jpa")
public interface AddressRepository extends CrudRepository<Address, Long> {
}
