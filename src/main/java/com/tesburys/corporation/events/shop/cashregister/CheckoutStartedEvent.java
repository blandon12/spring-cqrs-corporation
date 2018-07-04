package com.tesburys.corporation.events.shop.cashregister;

public class CheckoutStartedEvent {

    private String id;

    public CheckoutStartedEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
