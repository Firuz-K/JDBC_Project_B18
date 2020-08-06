package com.cybertek.jdbc.day2;


import com.cybertek.jdbc.Utility_Package.DB_Utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_practice2 {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();
        ResultSet rs =DB_Utility.runQuery("select * from employees");


        //DB_Utility.runQuery("select * from employees where salary>19000");
       // DB_Utility.displayAllData();


        System.out.println("DB_Utility.getRowDataAslList(2) = " + DB_Utility.getRowDataAslList(2));


    }
}
