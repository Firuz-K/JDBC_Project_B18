package com.cybertek.jdbc.day1;

import java.sql.*;

public class IntaratingResultSet {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@54.157.173.68:1521:XE";
        String username = "hr";
        String password = "hr";


        Connection conn = DriverManager.getConnection(connectionStr,username,password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

        while(rs.next()){
            System.out.println("rs.getString(\"region_name\") = " + rs.getString("region_name"));
        }

      /*  System.out.println("rs.next() = " + rs.next());
        System.out.println("rs.getString(1) = " + rs.getString(2));
        System.out.println("rs.getString(\"region_name\") = " + rs.getString("region_name"));
        System.out.println("rs.getString(\"region_id\") = " + rs.getString("region_id"));
        System.out.println("rs.next() = " + rs.next());
        System.out.println("rs.getString(2) = " + rs.getString(2));
        System.out.println("rs.getString(\"region_id\") = " + rs.getString("region_id"));
        System.out.println("rs.getString(\"region_name\") = " + rs.getString("region_name"));


       */

        rs.close();
        stmt.close();
        conn.close();
    }


}
