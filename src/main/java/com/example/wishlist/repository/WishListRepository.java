package com.example.wishlist.repository;

import com.example.wishlist.config.ConnectionManager;
import com.example.wishlist.model.Account;
import com.example.wishlist.model.Gift;
import com.example.wishlist.model.GiftType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class WishListRepository {

    @Autowired
    ConnectionManager connectionManager;



    public Gift addGift (Gift gift){
        String SQL = "INSERT INTO Gift( giftTypeId, giftName, price, discount, quantityInStock, color, image) values (?,?,?,?,?,?,?)";
        Connection conn = this.connectionManager.getConnection();
        int num = 1;
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)){
           pstmt.setInt(num++, gift.getGiftTypeId());
           pstmt.setString(num++, gift.getGiftName());
           pstmt.setDouble(num++, gift.getPrice());
           pstmt.setDouble(num++, gift.getDiscount());
           pstmt.setInt(num++, gift.getQuantityInStock());
           pstmt.setString(num++, gift.getColor());
           pstmt.setString(num++, gift.getImage());
           pstmt.executeUpdate();
        }

        catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return  gift;
    }


     public List<Gift> findAllGift(){
        List<Gift> gifts = new ArrayList<Gift>();
        String SQL = "SELECT giftId, giftTypeId, giftName, price, discount, quantityInStock, color, image FROM Gift";
        Connection conn = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int giftId = rs.getInt("giftId");
                int giftTypeId = rs.getInt("giftTypeId");
                String giftName = rs.getString("giftName");
                double price = rs.getDouble("price");
                double discount = rs.getDouble("discount");
                int quantityInStock = rs.getInt("quantityInStock");
                String color = rs.getString("color");
                String image = rs.getString("image");

                Gift gift = new Gift(giftId, giftTypeId, giftName, price, discount, quantityInStock, color, image);
                gift.setGiftId(giftId);
                gifts.add(gift);
            }
            return gifts;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
     }

     public Gift editWishList(int id, Gift gift){
        String SQL = "Update Gift Set" +
                "giftTypeId = ?" +
                "giftName = ?" +
                "price = ?" +
                "discount = ?" +
                "quantityInStock = ?" +
                "color = ?" +
                "image = ?" +
                "Where giftId = ?";
        Connection conn = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)){
          pstmt.setInt(1, gift.getGiftTypeId());
          pstmt.setString(2, gift.getGiftName());
          pstmt.setDouble(3, gift.getPrice());
          pstmt.setDouble(4, gift.getDiscount());
          pstmt.setInt(5, gift.getQuantityInStock());
          pstmt.setString(6, gift.getColor());
          pstmt.setString(7, gift.getImage());
          pstmt.setInt(8, id);
          pstmt.executeUpdate();
          return gift;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
     }

     public void deleteGift(int giftId){
        String SQL = "Delete From Gift Where giftId = ?";
        Connection conn = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setInt(1, giftId);
            pstmt.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
     }

    public List<GiftType> getGiftTypes(){
        List<GiftType> giftTypes = new ArrayList<>();
        String SQL = "Select typeId, typeName From GiftType";
        Connection conn = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)){
          ResultSet rs =pstmt.executeQuery();
          while (rs.next()){
              int typeId = rs.getInt("typeId");
              String typeName = rs.getString("typeName");
          }
          return giftTypes;
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public String getGiftTypeById(int id){
        String SQL = "Select typeName From GiftType Where typeId = ?";
        Connection conn = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                return rs.getString("typeName");
            }
            return "";
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    public Gift getGiftById(int giftId){
        Gift gift = null;
        String SQL = "Select  giftTypeId, giftName, price, discount, quantityInStock, color, image";
        Connection conn = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setInt(1, giftId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                int giftTypeId = rs.getInt("giftTypeId");
                String giftName = rs.getString("giftName");
                double price = rs.getDouble("price");
                double discount = rs.getInt("discount");
                int quantityInStock = rs.getInt("quantityInStock");
                String color = rs.getString("color");
                String image = rs.getString("image");
                int typeId = rs.getInt("typeId");
                gift = new Gift(typeId,giftTypeId, giftName, price, discount, quantityInStock, color, image);
                gift.setGiftId(giftId);
            }
            return gift;
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

     public List<Account> findAllAccount(){
         List<Account> accounts = new ArrayList<Account>();
         String SQL = "SELECT accountId, username, password, email, balance, fullName, addressId, tlf FROM Account";
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
                 int addressId = rs.getInt("addressId");
                 String tlf = rs.getString("tlf");

                 Account account = new Account(accountId, username, password, email, balance, fullName, addressId, tlf );
                 account.setAccountId(accountId);
                 accounts.add(account);
             }
             return accounts;
         }catch (SQLException e){
             throw new RuntimeException(e);
         }
     }

    public List<GiftType> findAllGiftType(){
        List<GiftType> gifts = new ArrayList<>();
        String SQL = "SELECT typeId, typeName FROM GiftType";
        Connection conn = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int giftTypeId = rs.getInt("typeId");
                String giftName = rs.getString("typeName");

                GiftType gift = new GiftType(giftTypeId, giftName);
                gifts.add(gift);
            }
            return gifts;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

     }





