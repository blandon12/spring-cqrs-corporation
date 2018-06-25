package com.tesburys.corporation.httpapi.shop.cashregister;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CashRegisterListView {
    @Id
    private String cashRegisterId;

    @Column
    private String state;

    public CashRegisterListView() {
    }

    public CashRegisterListView(String cashRegisterId, String state) {
        this.cashRegisterId = cashRegisterId;
        this.state = state;
    }

    public String getCashRegisterId() {
        return cashRegisterId;
    }

    public void setCashRegisterId(String cashRegisterId) {
        this.cashRegisterId = cashRegisterId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
