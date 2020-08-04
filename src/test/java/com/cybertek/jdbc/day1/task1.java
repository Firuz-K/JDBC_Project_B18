package com.cybertek.jdbc.day1;

import java.sql.*;

public class task1 {

    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@54.157.173.68:1521:XE";
        String username = "hr";
        String password = "hr";

        // GETTING DATABASE CONNECTION TO THE SERVER
        Connection conn = DriverManager.getConnection(connectionStr,username,password);
        // CREATING SIMPLE STATEMENT (forward only)
        Statement stmt = conn.createStatement();
        // GETTING RESULTSET OF THE QUERY
        ResultSet rs = stmt.executeQuery("SELECT * FROM countries");
        while(rs.next()){
            System.out.println(rs.getString("country_name") + ""+rs.getString("country_id"));
            System.out.println("rs.getString(1) = " + rs.getString(1));
        }


        // we have to close everything
        rs.close();
        stmt.close();
        conn.close();



    }
}
