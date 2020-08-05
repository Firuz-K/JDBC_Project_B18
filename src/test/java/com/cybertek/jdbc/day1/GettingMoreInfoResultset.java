package com.cybertek.jdbc.day1;

import java.sql.*;
import java.util.ArrayList;

public class GettingMoreInfoResultset {

    public static void main(String[] args) throws SQLException {


        String connectionStr = "jdbc:oracle:thin:@54.157.173.68:1521:XE";
        String username = "hr";
        String password = "hr";

        // GETTING DATABASE CONNECTION TO THE SERVER
        Connection conn = DriverManager.getConnection(connectionStr,username,password);
        // CREATING SIMPLE STATEMENT (forward only)
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        // GETTING RESULTSET OF THE QUERY
        ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

        //Metadata is info about data, like column count,column name, variable type

        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount=rsmd.getColumnCount();
        System.out.println(columnCount);

        // find out column name according to index
        System.out.println("rsmd.getColumnName(2) = " + rsmd.getColumnName(2));

        // HOw to list all column name from result set

        for(int i =1; i<=columnCount;i++){

            System.out.println("rsmd.getColumnName ("+i+ ") = " + rsmd.getColumnName(i));
        }

        ArrayList<String> columnNamelist= new ArrayList<>();

        for(int i=1;i<columnCount;i++){
            columnNamelist.add(rsmd.getColumnName(i));
        }

        System.out.println("columnNamelist = " + columnNamelist);

        rs.close();
        stmt.close();
        conn.close();

    }
}
