package com.tesburys.corporation.events.shop.cashregister;

import java.math.BigDecimal;

public class ProductAddedEvent {
    private String cashRegisterId;
    private String productCode;
    private BigDecimal price;

    public ProductAddedEvent(String cashRegisterId, String productCode, BigDecimal price) {
        this.cashRegisterId = cashRegisterId;
        this.productCode = productCode;
        this.price = price;
    }

    public String getCashRegisterId() {
        return cashRegisterId;
    }

    public String getProductCode() {
        return productCode;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
