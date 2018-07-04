package com.tesburys.corporation.events.shop.cashregister;

import com.tesburys.corporation.events.shop.cashregister.dto.BasketLine;
import java.util.List;

public class CheckoutCompletedEvent {

    private String cashRegisterId;
    private String paymentReference;
    private List<BasketLine> products;

    public CheckoutCompletedEvent(String cashRegisterId, String paymentReference, List<BasketLine> products) {
        this.cashRegisterId = cashRegisterId;
        this.paymentReference = paymentReference;
        this.products = products;
    }

    public String getCashRegisterId() {
        return cashRegisterId;
    }

    public List<BasketLine> getProducts() {
        return products;
    }

    public String getPaymentReference() {
        return paymentReference;
    }
}
