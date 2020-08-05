package com.cybertek.jdbc;
import com.cybertek.jdbc.day2.DB_Utility;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        //Replace the IP with your own IP address
        String connectionStr = "jdbc:oracle:thin:@54.157.173.68:1521:XE";
        String username = "hr";
        String password = "hr";

        // GETTING DATABASE CONNECTION TO THE SERVER
        Connection conn = DriverManager.getConnection(connectionStr,username,password);
        // CREATING SIMPLE STATEMENT (forward only)
        Statement stmt = conn.createStatement();
        // GETTING RESULTSET OF THE QUERY
        ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");
        // initially the cursor is at the location before first line of the resulting table
        // in order to move to first line  next() method is used.
        // it return true if there is a row at next location and move the cursor to next location
        // it return false if there is no more row next.
        rs.next() ;
        // right now we are at first row. to get column data as String
        System.out.println("First column value " + rs.getString(1)
                                        + " or " + rs.getString("REGION_ID") );
        System.out.println("SECOND column value " + rs.getString(2)
                                        + " or " + rs.getString("REGION_NAME") );
        rs.next() ;  // now moved to next row
        System.out.println("First column value " + rs.getString(1) + " or " + rs.getString("REGION_ID") );
        System.out.println("SECOND column value " + rs.getString(2) + " or " + rs.getString("REGION_NAME") );
        // test branch
        System.out.println("rs.next() = " + rs.next());

        System.out.println("Third COLUMN VALUE rs.getString(1) = " + rs.getString(1));
        System.out.println(" THIRD COLUMN VALUE rs.getString(2) = " + rs.getString(2));

        System.out.println("rs.getString(\"region_id\") = " + rs.getString("region_name"));

        System.out.println("rs.next() = " + rs.next());

        System.out.println("rs.getString(1) = " + rs.getString(1));
        System.out.println("rs.getString(\"region_name\") = " + rs.getString("region_name"));
        System.out.println("rs.getString(\"region_name\") = " + rs.getString("region_name"));

        System.out.println("rs.next() = " + rs.next());

        DB_Utility.destroy();

    }
}
