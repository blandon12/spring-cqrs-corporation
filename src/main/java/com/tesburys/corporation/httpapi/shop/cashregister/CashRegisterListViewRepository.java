package com.tesburys.corporation.httpapi.shop.cashregister;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashRegisterListViewRepository extends CrudRepository<CashRegisterListView, String> {}
