package com.Camp.SpringTest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnect {

    private static Connection conn;

    public static Connection connect() {
        conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/Users/37067/Desktop/Java/sqlite/db/testSQ.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }
    public void doSomething(){

    }


}
