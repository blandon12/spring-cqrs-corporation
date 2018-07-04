package com.tesburys.corporation.command.shop.cashregister;

public class CompletedCheckoutCommand {

    private String cashRegisterId;
    private String paymentReference;

    public CompletedCheckoutCommand(String cashRegisterId, String paymentReference) {
        this.cashRegisterId = cashRegisterId;
        this.paymentReference = paymentReference;
    }

    public String getCashRegisterId() {
        return cashRegisterId;
    }

    public String getPaymentReference() {
        return paymentReference;
    }
}
