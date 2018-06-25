package com.tesburys.corporation.command.shop.cashregister;

public class RegisterCashRegisterCommand {

    private final String id;

    public RegisterCashRegisterCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
