package com.example.wishlist.model;

public class Account {
    // Thuộc tính: Mô tả các đặc điểm của đối tượng
    private int accountId;// ID của cở sở dữ liệu
    private String username;
    private String password;
    private String email;
    private double balance;
    private String fullName;
    private int addressId;
    private String tlf;

    public Account(){

    }

    public Account(int accountId, String username, String password, String email, double balance, String fullName, int addressId, String tlf) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = balance;
        this.fullName = fullName;
        this.addressId = addressId;
        this.tlf = tlf;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }
}
