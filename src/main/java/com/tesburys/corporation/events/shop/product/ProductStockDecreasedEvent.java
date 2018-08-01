package com.tesburys.corporation.events.shop.product;

public class ProductStockDecreasedEvent {
    private String productCode;
    private int number;

    public ProductStockDecreasedEvent(String productCode, int number) {
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