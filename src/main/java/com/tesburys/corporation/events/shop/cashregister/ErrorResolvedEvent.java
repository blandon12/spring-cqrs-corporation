package com.tesburys.corporation.events.shop.cashregister;

public class ErrorResolvedEvent {
    private String cashRegisterId;
    private String errorType;

    public ErrorResolvedEvent(String cashRegisterId, String errorType) {
        this.cashRegisterId = cashRegisterId;
        this.errorType = errorType;
    }

    public String getCashRegisterId() {
        return cashRegisterId;
    }

    public String getErrorType() {
        return errorType;
    }
}
