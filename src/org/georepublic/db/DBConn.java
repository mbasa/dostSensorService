package org.georepublic.db;

import java.sql.*;
import java.util.*;

import org.georepublic.properties.DBProperties;

public class DBConn {

	private String host;
	private String user;
	private String password;
	private String db;
	private String port = "5432";
	
	public DBConn(){
		this.host     = DBProperties.getHost();
		this.user     = DBProperties.getUser();
		this.password = DBProperties.getPassword();
		this.db       = DBProperties.getDatabase();
		this.port     = DBProperties.getPort();
	}
	
	public DBConn(String host,String user,String pass,String db) {
		this.host     = host;
		this.user     = user;
		this.password = pass;
		this.db       = db;		
	}
	
	public DBConn(String host,String user,String pass,
			String db,String port) {
		this.host     = host;
		this.user     = user;
		this.password = pass;
		this.db       = db;		
		this.port     = port;
	}
	
	public Connection getConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Couldn't find the driver!");
			cnfe.printStackTrace();
		}

		Connection conn = null;

		String url = "jdbc:postgresql://" + this.host 
				+ ":"+ this.port + "/"
				+ this.db;

		Properties props = new Properties();

		props.setProperty("user", this.user);
		props.setProperty("password", this.password);

		try {
			conn = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
}
