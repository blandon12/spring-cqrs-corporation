package com.tesburys.corporation.command.shop.cashregister;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class BeginCheckoutCommand {

    @TargetAggregateIdentifier
    private String cashRegisterId;

    public BeginCheckoutCommand(String cashRegisterId) {
        this.cashRegisterId = cashRegisterId;
    }

    public String getCashRegisterId() {
        return cashRegisterId;
    }
}
