package com.tesburys.corporation.command.shop.product;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class IncreaseProductStockCommand {
    @TargetAggregateIdentifier
    private String productCode;
    private int number;

    public IncreaseProductStockCommand(String productCode, int number) {
        this.productCode = productCode;
        this.number = number;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getNumber() {
        return number;
    }
}