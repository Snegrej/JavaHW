package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database
{

    public static void main( String[] args )
    {
        new Database().run();
    }

    private Connection connection = null;

    public Connection getConnection() {
        if (connection == null) {
            synchronized (this) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection("jdbc:sqlite:database.db");
                    } catch (SQLException ex) {
                        Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return connection;
    }



    public void run(){

    }
}
