package com.models;

import java.sql.*;
import java.util.List;

import javax.management.Query;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionDB {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	

	public ConnectionDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
	      // Create a connection to the database 
	      String serverName = "sql2.freesqldatabase.com:3306"; 
	      String mydatabase = "sql233805"; 
	      String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // a JDBC url 
	      String username = "sql233805"; 
	      String password = "bH1*zJ1!"; 
	      connect = DriverManager.getConnection(url, username, password);
		 } catch (ClassNotFoundException e) { 
	    	  System.out.println(e);
	      } catch (SQLException e) { 
	    	  System.out.println(e);
	      } 
	}



	public ResultSet readDataBase(String sql) throws Exception {      
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	
}


