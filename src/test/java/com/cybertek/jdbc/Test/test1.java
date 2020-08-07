package com.cybertek.jdbc.Test;




import com.cybertek.jdbc.Utility_Package.DB_Utility;

import static com.cybertek.jdbc.Utility_Package.DB_Utility.*;


import java.sql.*;

public class test1 {

    public static void main(String[] args) throws SQLException {

        createConnection();

       runQuery("Select * from countries");

        System.out.println(getColumnCNT());

        destroy();











    }
}
