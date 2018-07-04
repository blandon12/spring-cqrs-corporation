package com.tesburys.corporation.command.shop.cashregister;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class ResolveCurrentErrorCommand {

    @TargetAggregateIdentifier
    private String cashRegisterId;

    public ResolveCurrentErrorCommand(String cashRegisterId) {
        this.cashRegisterId = cashRegisterId;
    }

    public String getCashRegisterId() {
        return cashRegisterId;
    }
}
