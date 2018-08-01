package com.tesburys.corporation.integration.shop.cashregister.pricelookup;

import com.tesburys.corporation.shop.cashregister.ProductPriceLookup;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class ProductPriceLookupImpl implements ProductPriceLookup {

    private PriceLookupViewRepository repository;

    @Override
    public Optional<BigDecimal> findPriceForProductCode(String productCode) {
        PriceLookupView priceLookupView = repository.findById(productCode).orElseThrow(() -> new RuntimeException("Product not found"));

        return Optional.of(priceLookupView.getPrice());
    }
}
