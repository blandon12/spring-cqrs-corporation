package com.tesburys.corporation.shop.product;


import com.tesburys.corporation.events.shop.product.ProductAddedEvent;
import com.tesburys.corporation.events.shop.product.ProductPriceChangedEvent;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventsourcing.EventSourcingHandler;
import java.math.BigDecimal;
import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@AggregateRoot
public class Product {

    @AggregateIdentifier
    private String productCode;
    private BigDecimal price;

    public Product() {

    }

    Product(String productCode, BigDecimal price) {
        apply(new ProductAddedEvent(productCode));
        apply(new ProductPriceChangedEvent(productCode, price));
    }

    public void changePrice(BigDecimal newPrice) {
        apply(new ProductPriceChangedEvent(productCode, newPrice));
    }

    @EventSourcingHandler
    public void on(ProductAddedEvent event) {
        productCode = event.getProductCode();
    }

    @EventSourcingHandler
    public void on(ProductPriceChangedEvent event) {
        price = event.getPrice();
    }
}

