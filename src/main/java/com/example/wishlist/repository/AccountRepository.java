package com.example.wishlist.repository;

import com.example.wishlist.config.ConnectionManager;
import com.example.wishlist.model.Account;
import com.example.wishlist.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountRepository {

    @Autowired
    ConnectionManager connectionManager;

    public Account addAccount (Account account){
        String SQL = "INSERT INTO Account(username, pass_word, email, balance, fullname, address, tlf) " +
                "values (?,?,?,?,?,?,?)";
        Connection conn = this.connectionManager.getConnection();
        int num = 1;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setString(num++, account.getUsername());
            pstmt.setString(num++, account.getPassword());
            pstmt.setString(num++, account.getEmail());
            pstmt.setDouble(num++, account.getBalance());
            pstmt.setString(num++, account.getFullName());
            pstmt.setString(num++, account.getAddress());
            pstmt.setString(num++, account.getTlf());
            pstmt.executeUpdate();
        }
        catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return  account;
    }

    public List<Account> findAllAccount(){
        List<Account> accounts = new ArrayList<Account>();
        String SQL = "SELECT accountId, username, pass_word, email, balance, fullName, address, tlf FROM Account";
        Connection conn = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int accountId = rs.getInt("accountId");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                double balance = rs.getDouble("balance");
                String fullName = rs.getString("fullName");
                String address = rs.getString("address");
                String tlf = rs.getString("tlf");

                Account account = new Account(accountId, username, password, email, balance, fullName, address, tlf );
                account.setAccountId(accountId);
                accounts.add(account);
            }
            return accounts;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Address> findAllAddress(){
        List<Address> addresses = new ArrayList<>();
        String SQL = "SELECT addressId, street, city, postcode FROM Address";
        Connection conn = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int addressId = rs.getInt("addressId");
                String street = rs.getString("street");
                String city = rs.getString("city");
                String postCode = rs.getString("postCode");

                Address address = new Address(addressId, street, city, postCode);
                addresses.add(address);
            }
            return addresses;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    public Account findByEmailOrUsername(String emailOrUserName){
        String SQL = "SELECT accountId, username, pass_word, email, balance, fullName, address, tlf FROM Account where username = ? or email = ?";
        Connection conn = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setString(1, emailOrUserName);
            pstmt.setString(2, emailOrUserName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int accountId = rs.getInt("accountId");
                String username = rs.getString("username");
                String password = rs.getString("pass_word");
                String email = rs.getString("email");
                double balance = rs.getDouble("balance");
                String fullName = rs.getString("fullName");
                String address = rs.getString("address");
                String tlf = rs.getString("tlf");

                Account account = new Account(accountId, username, password, email, balance, fullName, address, tlf );
                account.setAccountId(accountId);
                return account;
            }
            return null;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
