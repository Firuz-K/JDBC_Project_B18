package com.cybertek.jdbc.Test;

import com.cybertek.jdbc.Utility_Package.DB_Utility;

import java.sql.*;

public class test1 {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();

        ResultSet rs =UtilityPractice.runQuery("Select * from countries");

        rs.next();

        System.out.println("UtilityPractice.columnCount() = " + UtilityPractice.columnCount());

       // UtilityPractice.displayAllData();
        //UtilityPractice.getColumnDataAtRow(1,2);
       // UtilityPractice.getColumnDataAtRow(4,"country_name");

       UtilityPractice.getRowDataAslList(2);

        DB_Utility.destroy();







    }
}
