package com.cybertek.jdbc.day2;

import com.cybertek.jdbc.Utility_Package.DB_Utility;

import java.sql.*;



public class DB_practice {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();

        ResultSet rs  =DB_Utility.runQuery("select * from jobs");

        System.out.println("rs.next() = " + rs.next());

        System.out.println("rs.getString(\"first_name\") = " + rs.getString(1));

        System.out.println("Column Count " + DB_Utility.getColumnCNT());

        System.out.println("--------------------------------------------");

        DB_Utility.destroy();




    }

}
