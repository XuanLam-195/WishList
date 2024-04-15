package com.example.wishlist.model;

public class Order {
    private int orderId;
    private int accountId;

    public Order(int orderId, int accountId) {
        this.orderId = orderId;
        this.accountId = accountId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
