package com.tg.spring5.repository.map;

import com.tg.spring5.model.Address;
import com.tg.spring5.repository.database.AddressRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("default")
public class AddressMapRepository extends MapRepository<Address, Long> implements AddressRepository {
}
