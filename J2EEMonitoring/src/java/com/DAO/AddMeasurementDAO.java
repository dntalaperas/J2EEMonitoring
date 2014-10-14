package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class AddMeasurementDAO {
    public static void addMeasurement(int time) throws ClassNotFoundException, SQLException {
      Class.forName("com.mysql.jdbc.Driver");
      Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/algorithm_metrics", "root", "!uflow!");


      PreparedStatement preparedStatement = connect.prepareStatement("insert into  temp_measurement values (?)");
      preparedStatement.setInt(1, time);
      preparedStatement.executeUpdate();
      
      connect.close();
    }
    
    public static void insertMeasurement(String algorithm) throws SQLException, ClassNotFoundException {
      Class.forName("com.mysql.jdbc.Driver");
      Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/algorithm_metrics", "root", "!uflow!");


      Statement statement = connect.createStatement();
      ResultSet rs = statement.executeQuery("select time_elapsed FROM temp_measurement");
      if (rs.next()) {
          int time = rs.getInt("time_elapsed");
          PreparedStatement preparedStatement = connect.prepareStatement("insert into measurements values (default,?,NOW(),?)");
          preparedStatement.setString(1, algorithm);
          preparedStatement.setInt(2, time);
          preparedStatement.executeUpdate();
      }
      
      PreparedStatement preparedStatement = connect.prepareStatement("delete from temp_measurement where 1");
      preparedStatement.executeUpdate();      
      connect.close();        
    }

}
