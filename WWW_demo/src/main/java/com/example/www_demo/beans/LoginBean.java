package com.example.www_demo.beans;

import com.example.www_demo.ConnectMariaDB;
import org.mariadb.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginBean {

    public int Login(Object us, Object pwd){
        if (us.toString().isEmpty()||pwd.toString().isEmpty())
        {
            return 0;
        }
        if (us.equals("tu"))
        {
            if (pwd.equals("123")){
                return 1;
            }
            else return 2;
        }
        return -1;
    }
    public int LoginwithMariaDB(Object us, Object pwd) throws SQLException {
        ConnectMariaDB.getInstance();
        Connection con = ConnectMariaDB.getConnection();
        String sql = "SELECT * FROM taikhoan WHERE User = ? AND Pwd = ?";

        PreparedStatement stmt = null;
        int result = -1;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, us.toString());
            stmt.setString(2, pwd.toString());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                result = 1;
            }
            else {
                result = -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();}
    return result;
    }
}
