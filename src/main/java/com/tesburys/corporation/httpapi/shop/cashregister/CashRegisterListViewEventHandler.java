package com.tesburys.corporation.httpapi.shop.cashregister;

import com.tesburys.corporation.events.shop.cashregister.*;
import org.axonframework.eventhandling.EventHandler;

import java.util.Optional;

public class CashRegisterListViewEventHandler {

    private CashRegisterListViewRepository repository;

    public CashRegisterListViewEventHandler(CashRegisterListViewRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(CashRegisterRegisteredEvent event) {
        CashRegisterListView view = new CashRegisterListView(event.getId(), "IDLE");

        repository.save(view);
    }

    @EventHandler
    public void on(AcceptingProductsStartedEvent event) {
        Optional<CashRegisterListView> listView = repository.findById(event.getCashRegistered());

        CashRegisterListView cashRegisterListView = listView.orElseThrow(() -> new RuntimeException("Not found"));
        cashRegisterListView.setState("accepting");

        repository.save(cashRegisterListView);
    }

    @EventHandler
    public void on(ProductPriceNotFoundErrorEvent event) {

        Optional<CashRegisterListView> listView = repository.findById(event.getCashRegisterId());

        CashRegisterListView cashRegisterListView = listView.orElseThrow(() -> new RuntimeException("Not found"));
        cashRegisterListView.setState("error");

        repository.save(cashRegisterListView);
    }

    @EventHandler
    public void on(CheckoutStartedEvent event) {
        Optional<CashRegisterListView> listView = repository.findById(event.getId());

        CashRegisterListView cashRegisterListView = listView.orElseThrow(() -> new RuntimeException("Not found"));
        cashRegisterListView.setState("checkout");

        repository.save(cashRegisterListView);
    }

    @EventHandler
    public void on(CheckoutCompletedEvent event) {
        Optional<CashRegisterListView> listView = repository.findById(event.getCashRegisterId());

        CashRegisterListView cashRegisterListView = listView.orElseThrow(() -> new RuntimeException("Not found"));
        cashRegisterListView.setState("accepting");

        repository.save(cashRegisterListView);
    }
}
