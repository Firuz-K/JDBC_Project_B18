package com.cybertek.jdbc.Test;

import java.sql.*;
import java.util.*;

public class test2 {


    public static void main(String[] args) throws SQLException {


        String conn = "jdbc:oracle:thin:@54.157.173.68:1521:XE";
        String username = "hr";
        String password ="hr";


        Connection connection = DriverManager.getConnection(conn, username,password);

        Statement stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

         ResultSet rs= stmt.executeQuery("Select * from employees");

        //System.out.println("rs.next() = " + rs.next());





        ResultSetMetaData rsmd = rs.getMetaData();

        Map<String,String> mapList = new HashMap<>();

        while(rs.next()){

            for(int i =1; i <=rsmd.getColumnCount(); i++){
                mapList.put(rs.getString(2),rs.getString(3));
            }

        }
        System.out.println("mapList.size() = " + mapList.size());



        System.out.println(mapList);







    }
}
