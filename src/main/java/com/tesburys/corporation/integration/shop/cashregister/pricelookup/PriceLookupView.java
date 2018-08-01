package com.tesburys.corporation.integration.shop.cashregister.pricelookup;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class PriceLookupView {

    private String productCode;
    private BigDecimal price;

    public PriceLookupView(String productCode, BigDecimal price) {
        this.productCode = productCode;
        this.price = price;
    }

    public PriceLookupView(String productCode) {
        this.productCode = productCode;
        this.price = BigDecimal.ZERO;
    }


    public String getProductCode() {
        return productCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
