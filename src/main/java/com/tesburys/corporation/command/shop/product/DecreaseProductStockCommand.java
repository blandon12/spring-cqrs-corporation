package com.tesburys.corporation.command.shop.product;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class DecreaseProductStockCommand {
    @TargetAggregateIdentifier
    private String productCode;
    private int number;

    public DecreaseProductStockCommand(String productCode, int number) {
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