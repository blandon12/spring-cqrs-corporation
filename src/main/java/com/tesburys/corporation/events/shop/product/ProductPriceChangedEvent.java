package com.tesburys.corporation.events.shop.product;

import java.math.BigDecimal;

public class ProductPriceChangedEvent {
    private String productCode;
    private BigDecimal price;

    public ProductPriceChangedEvent(String productCode, BigDecimal price) {
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
