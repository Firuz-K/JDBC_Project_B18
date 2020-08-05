package com.cybertek.jdbc.day2;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DB_practice2 {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();
        ResultSet rs =DB_Utility.runQuery("select * from employees");


        //DB_Utility.runQuery("select * from employees where salary>19000");
       // DB_Utility.displayAllData();

      System.out.println("DB_Utility.getColumnDataAtRow(3,2) = " + DB_Utility.getColumnDataAtRow(3, 2));

        System.out.println(DB_Utility.getColumnDataAtRow(2,"first_name"));


        System.out.println("DB_Utility.getColumnDataAsList(2) = " + DB_Utility.getColumnDataAsList(2));


        DB_Utility.destroy();
    }
}
