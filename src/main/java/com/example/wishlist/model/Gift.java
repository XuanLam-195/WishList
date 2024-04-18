package com.example.wishlist.model;

import java.util.List;

public class Gift {
    private Integer giftId;
    private int giftTypeId;
    private String giftName;
    private double price;
    private double discount;
    private int quantityInStock;
    private String  color;
    private String image;

    public Gift() {
    }

    private List<Gift> giftTypes;

    public Gift(Integer giftId, int giftTypeId, String giftName, double price, double discount, int quantityInStock, String color, String image) {
        this.giftId = giftId;
        this.giftTypeId = giftTypeId;
        this.giftName = giftName;
        this.price = price;
        this.discount = discount;
        this.quantityInStock = quantityInStock;
        this.color = color;
        this.image = image;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public int getGiftTypeId() {
        return giftTypeId;
    }

    public void setGiftTypeId(int giftTypeId) {
        this.giftTypeId = giftTypeId;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Gift> getGiftTypes() {
        return giftTypes;
    }

    public void setGiftTypes(List<Gift> giftTypes) {
        this.giftTypes = giftTypes;
    }
}
