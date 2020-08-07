package com.cybertek.jdbc.Utility_Package;


import java.sql.*;
import java.util.*;

public  class DB_Utility {

    /*
    * a  static method to create a connection
    * with valid URL ,username and password
     */


    private static Connection conn;

    private static ResultSet rs;

     private static ResultSetMetaData rsmd ;

    private static Statement statement;//execute query



  public static void createConnection(){

       String connectionStr = "jdbc:oracle:thin:@54.157.173.68:1521:XE";
        String username = "hr";
        String password = "hr";
        try {
             conn = DriverManager.getConnection(connectionStr, username, password);
            System.out.println("CONNECTION SUCCESSFUL");
        }catch (SQLException e){
            System.out.println("CONNECTION HAS FAILED !!!");
            e.printStackTrace();
        }
    }



    public static void createConnection(String url, String username,String password){

         url = ConfigurationReader.getProperty("database.URL");
         username = ConfigurationReader.getProperty("database.username");
          password = ConfigurationReader.getProperty("database.password");


        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("CONNECTION SUCCESSFUL");
        }catch (SQLException e){
            System.out.println("CONNECTION HAS FAILED !!!");
            e.printStackTrace();
        }
    }



    public static void createConnection(String environment){

        String connectionStr = ConfigurationReader.getProperty(environment+".database.URL");
        String username = ConfigurationReader.getProperty(environment+".database.username");
        String password = ConfigurationReader.getProperty(environment+".database.password");

       createConnection(connectionStr,username,password);
    }


    /*
     * a static method to get the ResultSet and object
     * with valid connection by executing query
     */
    public static ResultSet runQuery(String Query){

        try {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(Query);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

    /*
     * a static method to get a column count

     */

    public static int getColumnCNT() {

        int colCount = 0;

        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            colCount = rsmd.getColumnCount();

        } catch (SQLException e) {
            System.out.println("ERROR WHILE COUNTING THE COLUMNS");
            e.printStackTrace();
        }

        return colCount;
    }


    public static void displayAllData(){
        int colCount = DB_Utility.getColumnCNT();
        try {
            rs.beforeFirst();
        while(rs.next()) {
            for (int i = 1; i <= colCount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
                rs.beforeFirst();
        } catch (SQLException e) {
            System.out.println("Error while getting all data");
            e.printStackTrace();
        }

    }


    /*
     * Getting single column cell value at certain row
     * row 2 column 3  -->> the data
     * */
    /**
     * Getting single column cell value at certain row
     * @param rowNum    row number we want to get data from
     * @param columnIndex  column index we want to get the data from
     * @return the data in String
     */
    public static String getColumnDataAtRow (int rowNum , int columnIndex){

        String result ="";
        try {
            rs.absolute(rowNum);
           result= rs.getString(columnIndex);
        } catch (SQLException e) {
            System.out.println("Error while getColumnDataAtRow");
            e.printStackTrace();
        }

        return result;

    }

    // this is overloaded  method from above and it is take a String

    public static String getColumnDataAtRow (int rowNum , String columnName){

        String result ="";
        try {
            rs.absolute(rowNum);
            result= rs.getString(columnName);
        } catch (SQLException e) {
            System.out.println("Error while getColumnDataAtRow");
            e.printStackTrace();
        }

        return result;

    }

    // getting entire row of data and return as list of Strings


    public static List<String> getRowDataAslList(int rowNum){

        List<String> RowDataList = new ArrayList<>();

        try {
            rs.absolute(rowNum);
            for(int i =1; i<=getColumnCNT(); i++){
                RowDataList.add(rs.getString(i));
            }
            rs.beforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return RowDataList;
    }



    public static int getRowCount(){
        int rowCount=0;
        try {
            rowCount=rs.getRow();
            rs.beforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }


    public static List<String> getColumnDataAsList(int columnIndex){

        List<String> columnDataLst = new ArrayList<>();
        try {
            rs.beforeFirst();  // moving the cursor to before first location

            while(rs.next() ){

                String data =  rs.getString(columnIndex) ;
                // getting the data from that column and adding to the the list
                columnDataLst.add( data  );

            }
            rs.beforeFirst();  // moving the cursor to before first location after we are done
        } catch (SQLException throwables) {
            System.out.println("ERROR WHILE getColumnDataAsList ");
            throwables.printStackTrace();
        }

        //System.out.println(columnDataLst);
        return columnDataLst;
    }

    public static List<String> getColumnDataAsList(String columnName){

        List<String> columnDataLst = new ArrayList<>();
        try {
            rs.beforeFirst();  // moving the cursor to before first location

            while(rs.next() ){

                String data =  rs.getString(columnName) ;
                // getting the data from that column and adding to the the list
                columnDataLst.add( data  );

            }
            rs.beforeFirst();  // moving the cursor to before first location after we are done
        } catch (SQLException throwables) {
            System.out.println("ERROR WHILE getColumnDataAsList ");
            throwables.printStackTrace();
        }

        return columnDataLst;
    }

    public static void destroy() {
        try {
            if (rs != null) {
                rs.close();
            }
            if ( statement!= null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
            System.out.println("SESSION DISCONNECTED");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to close database connection!");
        }
    }


    public static Map<String,String> getRowMap( int rowNum ){

        Map<String,String> rowMap = new LinkedHashMap<>();
        try{

            rs.absolute(rowNum);

            ResultSetMetaData rsmd = rs.getMetaData();
            for (int colNum = 1; colNum <= getColumnCNT() ; colNum++) {
                String colName = rsmd.getColumnName( colNum );
                String colValue= rs.getString( colNum ) ;
                rowMap.put(colName, colValue);
            }
            rs.beforeFirst();

        }catch (SQLException e){
            System.out.println("ERRROR AT ROW MAP FUNCTION");
        }

        return rowMap;
    }

    /**
     *
     * @return The entire resultset as List of Row Map
     */
    public static List<Map<String,String>> getAllDataAsListOfMap(){

        List<Map<String,String> > rowMapList = new ArrayList<>();
        for (int i = 1; i <= getRowCount(); i++) {
            rowMapList.add(   getRowMap(i)    ) ;
        }
        return rowMapList ;

    }



}



