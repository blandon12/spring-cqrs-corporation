package com.tesburys.corporation.command.warehouse.product;

public class CreateProductCommand {

    private String productCode;

    public CreateProductCommand(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }
}
