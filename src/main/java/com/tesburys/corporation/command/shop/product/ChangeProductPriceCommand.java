package com.tesburys.corporation.command.shop.product;

import org.axonframework.commandhandling.TargetAggregateIdentifier;
import java.math.BigDecimal;

public class ChangeProductPriceCommand {

    @TargetAggregateIdentifier
    private String productCode;
    private BigDecimal price;

    public ChangeProductPriceCommand(String productCode, BigDecimal price) {
        this.productCode = productCode;
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
