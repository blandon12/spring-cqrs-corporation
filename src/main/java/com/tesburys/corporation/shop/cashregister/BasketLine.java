package com.tesburys.corporation.shop.cashregister;

import java.math.BigDecimal;

public class BasketLine {

    private String productCode;
    private BigDecimal price;

    public BasketLine(String productCode, BigDecimal price) {
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
