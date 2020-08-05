package com.cybertek.jdbc.day1;

import java.sql.*;

public class Spartan {


    public static void main(String[] args) throws SQLException {


        String conStr = "jdbc:oracle:thin:@54.157.173.68:1521:XE";
        String username ="SP";
        String password ="SP";


        Connection conn = DriverManager.getConnection(conStr,username,password);

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = stmt.executeQuery("select * from spartans");


        rs.close();
        stmt.close();
        conn.close();


    }

}
