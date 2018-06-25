package com.tesburys.corporation.httpapi.shop.contract;

public class CashRegisterRegisteredResponse {

    private final String cashRegisterId;

    public CashRegisterRegisteredResponse(String cashRegisterId) {
        this.cashRegisterId = cashRegisterId;
    }

    public String getCashRegisterId() {
        return cashRegisterId;
    }
}
