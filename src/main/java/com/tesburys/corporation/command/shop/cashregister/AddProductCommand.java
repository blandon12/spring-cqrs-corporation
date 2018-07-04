package com.tesburys.corporation.command.shop.cashregister;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.math.BigDecimal;

public class AddProductCommand {

    @TargetAggregateIdentifier
    private String cashRegisterId;
    private String productCode;

    public AddProductCommand(String cashRegisterId, String productCode) {
        this.cashRegisterId = cashRegisterId;
        this.productCode = productCode;
    }

    public String getCashRegisterId() {
        return cashRegisterId;
    }

    public String getProductCode() {
        return productCode;
    }
}
