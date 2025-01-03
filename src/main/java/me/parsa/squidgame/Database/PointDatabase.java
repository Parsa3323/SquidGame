package me.parsa.squidgame.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PointDatabase {

    private final Connection connection;


    public PointDatabase(String path) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path);


        try (Statement statement = connection.createStatement()){
            statement.execute("CREATE TABLE IF NOT EXIST players (" + "uuid TEXT PRIMARY KEY, " + "user TEXT NOT NULL, " + "points INTEGER NOT NULL DEFAULT 0)"); //https://w3schools.com
        }
//        statement.execute("CREATE TABLE IF NOT EXIST players (" + "uuid TEXT PRIMARY KEY, " + "user TEXT NOT NULL, " + "points INTEGER NOT NULL DEFAULT 0)"); //https://w3schools.com
//        statement.close();
    }

    public void closeConection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }


}
