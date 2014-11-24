/**
 *  DostSensor Service
 *  
 *   Copyright (C) November,2014  Mario Basa
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

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
