package com.example.wishlist.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class Account implements UserDetails {
    // Thuộc tính: Mô tả các đặc điểm của đối tượng
    private int accountId;// ID của cở sở dữ liệu
    private String username;
    private String pass_word;
    private String email;
    private double balance;
    private String fullName;
    private String address;
    private String tlf;

    public Account(){

    }


    public Account(int accountId, String username, String pass_word, String email, double balance, String fullName, String address, String tlf) {
        this.accountId = accountId;
        this.username = username;
        this.pass_word = pass_word;
        this.email = email;
        this.balance = balance;
        this.fullName = fullName;
        this.address = address;
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

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return pass_word;
    }

    public void setPassword(String password) {
        this.pass_word = password;
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

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }
}
