package com.cybertek.jdbc.day1;

import java.sql.*;

public class MovingForwardandBackwards {

    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@54.157.173.68:1521:XE";
        String username = "hr";
        String password = "hr";

        // GETTING DATABASE CONNECTION TO THE SERVER
        Connection conn = DriverManager.getConnection(connectionStr,username,password);
        // CREATING SIMPLE STATEMENT (forward only)
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        // GETTING RESULTSET OF THE QUERY
        ResultSet rs = stmt.executeQuery("SELECT * FROM countries");

        System.out.println("rs.next() = " + rs.next());

        System.out.println("country_name = " + rs.getString("country_name"));

        System.out.println("rs.next() = " + rs.next());

        System.out.println("country_name = " + rs.getString("country_name"));

        System.out.println("rs.previous() = " + rs.previous());

        System.out.println("country_name = " + rs.getString("country_name"));

        // moving to the last row directly
        System.out.println("rs.last() = " + rs.last());
        System.out.println("country_name = " + rs.getString("country_name"));

        // moving to the first row directly
        System.out.println("rs.first() = " + rs.first());
        System.out.println("country_name = " + rs.getString("country_name"));

        System.out.println("rs.absolute(5) = " + rs.absolute(5));
        System.out.println("country_name = " + rs.getString("country_name"));

        rs.beforeFirst();
        rs.last();
        rs.afterLast();

        System.out.println("Counting backwards");
        while(rs.previous()){
            System.out.println("Country_name = " + rs.getString("country_name"));
        }

        rs.last();

        System.out.println("rs.getRow() = " + rs.getRow());

        // metadata is a data about the data



    }
}
