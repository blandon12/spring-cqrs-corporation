package com.tesburys.corporation.shop.cashregister;

import com.tesburys.corporation.events.shop.cashregister.*;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventsourcing.EventSourcingHandler;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@AggregateRoot
public class CashRegister {


    private enum State {
        IDLE,
        ACCEPTING_PRODUCTS,
        ERROR_PRICE_NOT_FOUND
    }

    @AggregateIdentifier
    private String id;
    private State currentState;
    private List<BasketLine> basket = new LinkedList<>();

    public CashRegister() {
    }

    void startAcceptingProducts() {
        if (!currentState.equals(State.IDLE)) {
            throw new RuntimeException("Invalid state " + currentState.toString());
        }

        apply(new AcceptingProductsStartedEvent(id));

    }

    public CashRegister(String id) {
        apply(new CashRegisterRegisteredEvent(id));
    }

    void addProduct(String productCode, BigDecimal price) throws Exception {

        if (currentState.equals(State.ACCEPTING_PRODUCTS)) {
            apply(new ProductAddedEvent(id, productCode, price));
        } else {
            throw new Exception(String.format("Can't accept product in state %s", currentState));
        }
    }

    void changeToErrorProductPriceNotFound(String productCode) {
        apply(new ProductPriceNotFoundErrorEvent(id, productCode));
    }

    void resolveCurrentError() {
        apply(new ErrorResolvedEvent(id, currentState.toString()));
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

    @EventSourcingHandler
    public void on(ProductAddedEvent event) {
        basket.add(new BasketLine(event.getProductCode(), event.getPrice()));
    }

    @EventSourcingHandler
    public void on(ProductPriceNotFoundErrorEvent event) {
        currentState = State.ERROR_PRICE_NOT_FOUND;
    }

    @EventSourcingHandler
    public void on(ErrorResolvedEvent event) {
        if (event.getErrorType().equals(State.ERROR_PRICE_NOT_FOUND.toString())) {
            currentState = State.ACCEPTING_PRODUCTS;
        }
    }
}
