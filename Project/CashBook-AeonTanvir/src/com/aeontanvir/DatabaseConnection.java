package com.aeontanvir;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class DatabaseConnection {

    public static Connection getConnection() throws ClassNotFoundException {
        String[] up = new String[]{"root",""};
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("dbinfo.txt")));
            String s = "";
            for(int i = 0; (s = br.readLine())!=null; i++){
                up[i]=s;
            }
        } catch (Exception e) {
            System.out.println("dbFile" + e);
        }  
        
        Class.forName("com.mysql.jdbc.Driver");
        String dblocation = "jdbc:mysql://localhost:3306/cashbook_aeontanvir";
        String key = up[0];
        String coin = up[1];
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(dblocation, key, coin);
            System.out.println("DatabaseConnection successfully");
            return con;
        } catch (Exception e) {
            System.err.println("DatabaseConnection error! \t" + e);
            return null;
        }

    }
}
