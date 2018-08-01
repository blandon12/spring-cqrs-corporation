package com.tesburys.corporation.events.shop.product;

public class ProductAddedEvent {
    private String productCode;

    public ProductAddedEvent(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }
}
