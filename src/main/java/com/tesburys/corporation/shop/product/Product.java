package com.tesburys.corporation.shop.product;

import com.tesburys.corporation.events.shop.product.ProductAddedEvent;
import com.tesburys.corporation.events.shop.product.ProductPriceChangedEvent;
import com.tesburys.corporation.events.shop.product.ProductStockDecreasedEvent;
import com.tesburys.corporation.events.shop.product.ProductStockIncreasedEvent;
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
    private int stock;

    public Product() {
    }

    Product(String productCode, BigDecimal price) {
        apply(new ProductAddedEvent(productCode));
        apply(new ProductPriceChangedEvent(productCode, price));
    }

    void changePrice(BigDecimal newPrice) {
        apply(new ProductPriceChangedEvent(productCode, newPrice));
    }

    void applyDiscount(BigDecimal percentOfDiscunt) {
        BigDecimal newPrice = price.multiply(BigDecimal.ONE.subtract(percentOfDiscunt));

//        apply(new DiscountAppliedEvent());
//        apply(new ProductPriceChangedEvent(productCode, newPrice));
    }

    void increaseStock(int number) {
        apply(new ProductStockIncreasedEvent(productCode, number));
    }

    void decreaseStock(int number) {
        apply(new ProductStockDecreasedEvent(productCode, number));

//        if (stock - number < 10) {
//            apply(new ProductStockLowEvent(productCode));
//        }
    }

    @EventSourcingHandler
    public void on(ProductAddedEvent event) {
        productCode = event.getProductCode();
        stock = 0;
    }

    @EventSourcingHandler
    public void on(ProductPriceChangedEvent event) {
        price = event.getPrice();
    }

    @EventSourcingHandler
    public void on(ProductStockIncreasedEvent event) {
        stock += event.getNumber();
    }

    @EventSourcingHandler
    public void on(ProductStockDecreasedEvent event) {
        stock -= event.getNumber();
    }
}