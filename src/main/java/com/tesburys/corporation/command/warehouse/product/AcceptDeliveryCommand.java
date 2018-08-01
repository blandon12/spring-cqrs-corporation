package com.tesburys.corporation.command.warehouse.product;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class AcceptDeliveryCommand {

    @TargetAggregateIdentifier
    private String productCode;
    private int amount;

    public AcceptDeliveryCommand(String productCode, int amount) {
        this.productCode = productCode;
        this.amount = amount;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getAmount() {
        return amount;
    }
}
