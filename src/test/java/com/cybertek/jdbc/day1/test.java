package com.cybertek.jdbc.day1;

import java.sql.*;

public class test {

    public static void main(String[] args) throws SQLException {

        String strconn ="jdbc:oracle:thin:@54.157.173.68:1521:XE";

        String username ="hr";
        String password ="hr";

        Connection conn = DriverManager.getConnection(strconn,username,password);

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = stmt.executeQuery("Select * from employees where first_name like '%a'");

        while (rs.next()){
            System.out.println("First_name = " + rs.getString("First_name"));
            System.out.println("Last_name) = " + rs.getString("last_name"));
        }



    }
}
