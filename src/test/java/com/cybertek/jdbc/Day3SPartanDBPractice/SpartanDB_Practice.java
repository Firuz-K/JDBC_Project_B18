package com.cybertek.jdbc.Day3SPartanDBPractice;


import static com.cybertek.jdbc.Utility_Package.DB_Utility.*;

import java.sql.*;

public class SpartanDB_Practice {

    public static void main(String[] args) throws SQLException {


        createConnection("dev");

       runQuery("select * from spartans");

        System.out.println(getColumnDataAsList("name"));

        destroy();


    }

}
