package edu.ci.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnexion {
	  private static DbConnexion instance;
	  private static Connection connection;
	  private final String url = "jdbc:mysql://localhost:3306/"+Constant.BDD;
	  private final String username = "root";
	  private final String password = "";
	  
	  private DbConnexion() throws SQLException {
	    try {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      this.connection = DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException ex) {
	      System.out.println("Something is wrong with the DB connection String : " + ex.getMessage());
	    }
	  }
	  public Connection getConnection() {
	    return connection;
	  }
	  
	  public static DbConnexion getInstance() throws SQLException {
	    if (instance == null) {
	      instance = new DbConnexion();
	    } else if (instance.getConnection().isClosed()) {
	      instance = new DbConnexion();
	    }
	    return instance;
	  }
	}