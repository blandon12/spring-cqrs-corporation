package com.tesburys.corporation.shop.cashregister;

import com.tesburys.corporation.events.shop.cashregister.AcceptingProductsStartedEvent;
import com.tesburys.corporation.events.shop.cashregister.CashRegisterRegisteredEvent;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventsourcing.EventSourcingHandler;
import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@AggregateRoot
public class CashRegister {


    private enum State {
        IDLE,
        ACCEPTING_PRODUCTS
    }

    @AggregateIdentifier
    private String id;
    private State currentState;

    public CashRegister() {
    }

    public void startAcceptingProducts() {
        if (!currentState.equals(State.IDLE)) {
            throw new RuntimeException("Invalid state " + currentState.toString());
        }

        apply(new AcceptingProductsStartedEvent(id));

    }

    public CashRegister(String id) {
        apply(new CashRegisterRegisteredEvent(id));
    }

    @EventSourcingHandler
    public void on(CashRegisterRegisteredEvent event) {
        id = event.getId();
        currentState = State.IDLE;
    }

    @EventSourcingHandler
    public void on(AcceptingProductsStartedEvent event) {
        currentState = State.ACCEPTING_PRODUCTS;
    }
}
