package com.example.wishlist.model;

public class Address {
    private int addressId;
    private String street;
    private String city;
    private String postCode;

    public Address(int addressId, String street, String city, String postCode) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.postCode = postCode;
    }

    public Address() {

    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
