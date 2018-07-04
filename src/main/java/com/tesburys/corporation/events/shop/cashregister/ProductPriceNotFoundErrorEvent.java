package com.tesburys.corporation.events.shop.cashregister;

public class ProductPriceNotFoundErrorEvent {

    private String cashRegisterId;
    private String productCode;

    public ProductPriceNotFoundErrorEvent(String cashRegisterId, String productCode) {
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
