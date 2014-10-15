/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jim
 */
public class TimeMeasureMentDAO {
    public static ArrayList<TimeMeasureMentEntry> getTimeMeasurements() throws ClassNotFoundException, SQLException {
        ArrayList<TimeMeasureMentEntry> entries = new ArrayList<TimeMeasureMentEntry>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/algorithm_metrics", "root", "!uflow!");


        Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery("select method, invocation, time_ellapsed FROM measurements where time_ellapsed > 0"); 
        while (rs.next()) {
            TimeMeasureMentEntry entry = new TimeMeasureMentEntry();
            entry.setDate(rs.getDate("invocation"));
            entry.setMethod(rs.getString("method"));
            entry.setTime(rs.getInt("time_ellapsed"));
            entries.add(entry);
        }
        
        return entries;
    }
    
    public static ArrayList<TimeMeasureMentEntry> getTimeMeasurements(String method) throws ClassNotFoundException, SQLException {
        ArrayList<TimeMeasureMentEntry> entries = new ArrayList<TimeMeasureMentEntry>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/algorithm_metrics", "root", "!uflow!");


        Statement statement = connect.createStatement();
        ResultSet rs = statement.executeQuery("select method, invocation, time_ellapsed FROM measurements where time_ellapsed > 2 AND method=\""+method+"\""); 
        while (rs.next()) {
            TimeMeasureMentEntry entry = new TimeMeasureMentEntry();
            entry.setDate(rs.getDate("invocation"));
            entry.setMethod(rs.getString("method"));
            entry.setTime(rs.getInt("time_ellapsed"));
            entries.add(entry);
        }
        
        return entries;
    }    
}
