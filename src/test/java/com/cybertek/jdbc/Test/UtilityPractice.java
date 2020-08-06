package com.cybertek.jdbc.Test;

import java.sql.*;
import java.util.*;

public class UtilityPractice {

     private static Connection conn;
     private static ResultSet rs;



     private static Statement stmt;

    public static void createConnection(){

        String connectionStr = "jdbc:oracle:thin:@54.157.173.68:1521:XE";
        String username ="hr";
        String password ="hr";

        try {
             conn = DriverManager.getConnection(connectionStr,username,password);
            System.out.println("Connection is established ");
        } catch (SQLException e) {
            System.out.println("Something wrong with the connection");
            e.printStackTrace();
        }


    }

    public static ResultSet runQuery(String Query){

        try {
            stmt=conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs=stmt.executeQuery(Query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
          return rs;
    }

    public static int columnCount(){

        int Count =0;
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            Count =rsmd.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Count;

    }

    public static void displayAllData(){

      int columnCount =columnCount();

        try {
            rs.beforeFirst();
            while(rs.next()){
                for(int i =1; i<=columnCount;i++){
                    System.out.print(rs.getString(i)+"  ");
                }
                System.out.println();
            }
            rs.beforeFirst();
        } catch (SQLException e) {
            System.out.println("Error during displayEverything");
            e.printStackTrace();
        }


    }

    public static void getColumnDataAtRow(int rowNumber, int columnNumber){

        try {
            rs.beforeFirst();
            rs.absolute(rowNumber);
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println( rs.getString(rsmd.getColumnName(columnNumber)));


        } catch (SQLException throwables) {

            System.out.println("Error during getColumnDataAtRow");
            throwables.printStackTrace();
        }
    }

    public static void getColumnDataAtRow(int rowNumber, String columnName){

        try {
            rs.beforeFirst();
            rs.absolute(rowNumber);
            System.out.println( rs.getString(columnName));
            rs.beforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<String> getRowDataAslList(int rowNum){

        List<String> dataRowList = new ArrayList<>() ;

        try{
            rs.absolute(rowNum);
            for(int i =1; i<=columnCount();i++){
                dataRowList.add(rs.getString(i));
            }
            rs.beforeFirst();
        }catch (SQLException e){
            System.out.println("Error during getRowDataAslList");
            e.printStackTrace();
            }
           System.out.println(dataRowList);
          return dataRowList;

            }

    public static List<String>  getColumnDataAsList(int columnNumber){

        List<String> columnData = new ArrayList<>();

        try{
            while(rs.next()){
                columnData.add(rs.getString(columnNumber));
            }
            rs.beforeFirst();
        }catch(SQLException e){
            e.printStackTrace();

        }
        System.out.println(columnData);
        return columnData;
    }

    public static int getRowCount(){

        int count =0;


        try {
            rs.beforeFirst();
            while (rs.next()) {
                count++;
            }
            rs.beforeFirst();
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println(count);
        return count;
    }

        }


