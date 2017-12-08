package com.app;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database
{

    public static void main( String[] args ) throws SQLException, FileNotFoundException{
        new Database().run();
    }

    private Connection connection = null;

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/sensorData.db");
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

    public void insert(int moistureLevel,String theDate,String dataTime) {
        String sql = "INSERT INTO dataSet(moistureLevel,theDate,dataTime) VALUES(?,?,?)";

        try{
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, moistureLevel);
            ps.setString(2, theDate);
            ps.setString(3, dataTime);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    Statement statement = null;
    public Statement getStatement(){
        try {
                connection = getConnection();
                statement = connection.createStatement();
                statement.setQueryTimeout(30);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        return statement;
    }

    void sql(String command){
      try {
            statement = getStatement();
            statement.executeUpdate(command);
          } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

    ResultSet rs = null;
    void selectByDate(String date) throws SQLException{
      String command = "SELECT * FROM dataSet WHERE theDate = " + "\"" + date + "\"";
      statement = getStatement();
      rs = statement.executeQuery(command);
      while (rs.next()) {
        System.out.println(rs.getInt("moistureLevel") +  "\t" + rs.getString("theDate") + "\t" + rs.getString("dataTime"));
        }
    }

    void printAllData() throws SQLException{
      String command = "SELECT * FROM dataSet";
      statement = getStatement();
      rs = statement.executeQuery(command);
      while (rs.next()) {
        System.out.println(rs.getInt("moistureLevel") +  "\t" + rs.getString("theDate") + "\t" + rs.getString("dataTime"));
        }
    }

    void reset(){
      sql("drop table if exists dataSet");
      sql("create table dataSet(moistureLevel integer, theDate string, dataTime string)");
    }

    void readData(String fileName) throws FileNotFoundException{
        int a;
        String b, c;
      Scanner sc = new Scanner(new File("src/main/resources/" + fileName));
      while(sc.hasNextLine()){
          a= sc.nextInt();
          b = sc.next();
          c = sc.next();
          insert(a,b,c);
      }
    }

    void run() throws SQLException, FileNotFoundException{
      reset();
      readData("sensorData.dat");
      printAllData();
      //selectByDate("2017-12-07");
    }
}
