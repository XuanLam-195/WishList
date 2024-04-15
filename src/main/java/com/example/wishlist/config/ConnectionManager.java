package com.example.wishlist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class ConnectionManager {

  private  Connection conn;

    @Value("${spring.datasource.url}")
    private  String db_url="jdbc:mysql://mywishlist.mysql.database.azure.com:3306/wishlist";

    @Value("${spring.datasource.username}")
    private  String uid="Lam";

    @Value("${spring.datasource.password}")
    private  String pwd="Peterlin0613847925";



  public  Connection getConnection(){
      if (conn != null)
          return conn;
      try{
          conn = DriverManager.getConnection(db_url, uid, pwd);
      }catch (SQLException e){
          System.out.println("Couldn't connect to db");
          e.printStackTrace();
      }
      return conn;
  }

}
