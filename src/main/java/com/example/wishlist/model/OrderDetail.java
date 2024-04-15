package com.example.wishlist.model;

import java.time.LocalDateTime;

public class OrderDetail {
    private int orderId;
    private int giftId;
    private int quantity;
    private double totalPrice;
    private  LocalDateTime orderDate;
    private LocalDateTime shippingDate;

    public OrderDetail(int orderId, int giftId, int quantity, double totalPrice, LocalDateTime orderDate, LocalDateTime shippingDate) {
        this.orderId = orderId;
        this.giftId = giftId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.shippingDate = shippingDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGiftId() {
        return giftId;
    }

    public void setGiftId(int giftId) {
        this.giftId = giftId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDateTime shippingDate) {
        this.shippingDate = shippingDate;
    }
}
