package com.tesburys.corporation.integration.shop.cashregister.pricelookup;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceLookupViewRepository extends CrudRepository<PriceLookupView, String> {
}
