package com.tesburys.corporation.events.warehouse.product;

public class ProductAddedEvent {
    private String productCode;
    private int amount;

    public ProductAddedEvent(String productCode, int amount) {
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
