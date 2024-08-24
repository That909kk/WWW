package com.example.www_demo;

import org.mariadb.jdbc.Connection;

import org.mariadb.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMariaDB {
   private static ConnectMariaDB instance = new ConnectMariaDB();
    public static Connection con=null;
    public static ConnectMariaDB getInstance(){
        return instance;
    }
    public void connect() throws SQLException {
      String url = "jdbc:mariadb://localhost:3306/that";
        String user = "root";
        String password = "sapassword";
        con = (Connection) DriverManager.getConnection(url, user, password);
    }
    public void disconnect() throws SQLException {
        if(con!=null){
          try {
            con.close();
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
    }
    public static Connection getConnection() {
        return con;
    }

    public static void main(String[] args) {
        ConnectMariaDB connectMariaDB = new ConnectMariaDB();
        try {
            connectMariaDB.connect();
            System.out.println("Ket Noi Thanh Cong");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
