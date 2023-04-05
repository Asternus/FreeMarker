package com.example.demo.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private String driverClass;
    private String dbURL;
    private String username;
    private char[] password;
    private Connection con;

    public DBConnection(String driverClass, String dbURL, String username, char[] password) {
        this.driverClass = driverClass;
        this.dbURL = dbURL;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        if (this.con != null)
            return con;

        Connection con = null;
        try {
            System.out.println("Creating DB Connection");
            Class.forName(driverClass);
            con = DriverManager.getConnection(dbURL, username, String.valueOf(password));
            System.out.println("Successfully Created DB Connection");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        this.con = con;
        return con;
    }

    public void close() {
        System.out.println("DBConnection close called");
        if (this.con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
