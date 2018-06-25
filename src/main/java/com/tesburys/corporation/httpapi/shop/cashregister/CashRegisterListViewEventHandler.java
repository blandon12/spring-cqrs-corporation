package com.tesburys.corporation.httpapi.shop.cashregister;

import com.tesburys.corporation.events.shop.cashregister.AcceptingProductsStartedEvent;
import com.tesburys.corporation.events.shop.cashregister.CashRegisterRegisteredEvent;

import java.util.Optional;

public class CashRegisterListViewEventHandler {

    private CashRegisterListViewRepository repository;

    public CashRegisterListViewEventHandler(CashRegisterListViewRepository repository) {
        this.repository = repository;
    }

    public void on(CashRegisterRegisteredEvent event) {
        CashRegisterListView view = new CashRegisterListView(event.getId(), "IDLE");

        repository.save(view);
    }

    public void on(AcceptingProductsStartedEvent event) {
        Optional<CashRegisterListView> listView = repository.findById(event.getCashRegistered());

        CashRegisterListView cashRegisterListView = listView.orElseThrow(() -> new RuntimeException("Not found"));
        cashRegisterListView.setState("accepting");

        repository.save(cashRegisterListView);
    }
}
