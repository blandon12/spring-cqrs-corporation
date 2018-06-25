package com.tesburys.corporation.events.shop.cashregister;

public class AcceptingProductsStartedEvent {

    private String cashRegistered;

    public AcceptingProductsStartedEvent(String cashRegistered) {
        this.cashRegistered = cashRegistered;
    }

    public String getCashRegistered() {
        return cashRegistered;
    }
}
