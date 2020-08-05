package com.cybertek.jdbc.day2;



import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DB_Practice3 {


    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();
        ResultSet rs =DB_Utility.runQuery("select * from countries");

        // store first row data as a MAP<String, String>
        // the key of the map is column name
        // value of the map is column data

        Map<String, String> rowMap = new HashMap<>();
        ResultSetMetaData rsmd = rs.getMetaData();
        while(rs.next()) {

            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                rowMap.put(rsmd.getColumnName(i), rs.getString(i));
            }
            System.out.println(rowMap.get("country_id"));
        }
        rs.beforeFirst();

        DB_Utility.destroy();












    }
}
