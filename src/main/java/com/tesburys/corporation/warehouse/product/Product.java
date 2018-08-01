package com.tesburys.corporation.warehouse.product;

import com.tesburys.corporation.events.warehouse.product.DeliveryAcceptedEvent;
import com.tesburys.corporation.events.warehouse.product.ProductAddedEvent;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateRoot;
import org.axonframework.eventsourcing.EventSourcingHandler;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@AggregateRoot
public class Product {
    @AggregateIdentifier
    private String productCode;
    private int stock;

    public Product() {
    }

    Product(String productCode) {
        this(productCode, 0);
    }

    Product(String productCode, int amount) {
        apply(new ProductAddedEvent(productCode, amount));
    }

    void acceptDelivery(int amount) {
        apply(new DeliveryAcceptedEvent(productCode, amount));
    }

    @EventSourcingHandler
    public void on(ProductAddedEvent event) {
        productCode = event.getProductCode();
        stock = event.getAmount();
    }

    @EventSourcingHandler
    public void on(DeliveryAcceptedEvent event) {
        stock += event.getAmount();
    }
}
