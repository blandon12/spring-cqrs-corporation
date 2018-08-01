package com.tesburys.corporation.integration.shop.cashregister.pricelookup;

import com.tesburys.corporation.events.shop.product.ProductAddedEvent;
import com.tesburys.corporation.events.shop.product.ProductPriceChangedEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PriceLookupEventHandler {

    private PriceLookupViewRepository priceLookupViewRepository;

    public PriceLookupEventHandler(PriceLookupViewRepository priceLookupViewRepository) {
        this.priceLookupViewRepository = priceLookupViewRepository;
    }

    public void on(ProductAddedEvent event) {
        PriceLookupView priceLookupView = new PriceLookupView(event.getProductCode());
        priceLookupViewRepository.save(priceLookupView);
    }

    public void on(ProductPriceChangedEvent event) {
        Optional<PriceLookupView> priceLookupViewOptional = priceLookupViewRepository.findById(event.getProductCode());

        if (priceLookupViewOptional.isPresent()) {
            PriceLookupView priceLookupView = priceLookupViewOptional.get();
            priceLookupView.setPrice(event.getPrice());
        } else {
            throw new RuntimeException("Product not found");
        }

    }
}
