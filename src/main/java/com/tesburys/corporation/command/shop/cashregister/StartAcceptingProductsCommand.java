package com.tesburys.corporation.command.shop.cashregister;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class StartAcceptingProductsCommand {

    @TargetAggregateIdentifier
    private String cashRegisterId;

    public StartAcceptingProductsCommand(String cashRegisterId) {
        this.cashRegisterId = cashRegisterId;
    }

    public String getCashRegisterId() {
        return cashRegisterId;
    }
}
