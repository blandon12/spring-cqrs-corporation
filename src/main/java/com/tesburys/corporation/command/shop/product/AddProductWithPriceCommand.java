package com.tesburys.corporation.command.shop.product;

import java.math.BigDecimal;

public class AddProductWithPriceCommand {

    private String productCode;
    private BigDecimal price;

    public AddProductWithPriceCommand(String productCode, BigDecimal price) {
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
