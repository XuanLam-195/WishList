package com.example.wishlist.repository;

import com.example.wishlist.config.ConnectionManager;
import com.example.wishlist.model.Account;
import com.example.wishlist.model.Address;
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

    public Gift updateGift (Gift gift){
        String SQL = "UPDATE Gift SET giftTypeId = ?, giftName = ?, price = ?, discount = ?, quantityInStock = ?, color = ?, image = ? Where giftId = ?";
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
            pstmt.setInt(num++, gift.getGiftId());
            pstmt.executeUpdate();
        }

        catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return  gift;
    }

    public void deleteGift (Integer id) {
        String SQL = "DELETE from Gift Where giftId = ? ";
        Connection conn = this.connectionManager.getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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


    public Gift getGiftById(int giftId){
        Gift gift = null;
        String SQL = "Select  * from Gift where giftId = ?";
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

                gift = new Gift(giftId,giftTypeId, giftName, price, discount, quantityInStock, color, image);
                gift.setGiftId(giftId);
            }
            return gift;
        }catch (SQLException e){
            throw  new RuntimeException(e);
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





