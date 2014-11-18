package org.georepublic.properties;

import java.util.ResourceBundle;

public class DBProperties {

	private static String password = null;
	private static String user     = null;
	private static String host     = null;
	private static String port     = null;
	private static String database = null;
	private static String keytable = null;
	
	public static void setProperties(){
		
		ResourceBundle resb = 
				ResourceBundle.getBundle("properties.database");
		
		setUser(resb.getString("USER"));
		setPassword(resb.getString("PASSWORD"));
	    setHost(resb.getString("HOST"));
	    setDatabase(resb.getString("DATABASE"));
	    setPort(resb.getString("PORT"));
	    //setKeytable(resb.getString("KEY_TABLE"));
	}
	
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		DBProperties.password = password;
	}
	public static String getUser() {
		return user;
	}
	public static void setUser(String user) {
		DBProperties.user = user;
	}
	public static String getHost() {
		return host;
	}
	public static void setHost(String host) {
		DBProperties.host = host;
	}
	public static String getPort() {
		return port;
	}
	public static void setPort(String port) {
		DBProperties.port = port;
	}
	public static String getDatabase() {
		return database;
	}
	public static void setDatabase(String database) {
		DBProperties.database = database;
	}

	public static String getKeytable() {
		return keytable;
	}

	public static void setKeytable(String keytable) {
		DBProperties.keytable = keytable;
	}
	
	
}
