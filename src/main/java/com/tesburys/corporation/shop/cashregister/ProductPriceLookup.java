package com.tesburys.corporation.shop.cashregister;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public interface ProductPriceLookup {

    Optional<BigDecimal> findPriceForProductCode(String productCode);
}
