package com.tesburys.corporation.events.shop.cashregister;

public class CashRegisterRegisteredEvent {

    private final String id;

    public CashRegisterRegisteredEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
