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

package org.georepublic.db.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.wink.json4j.JSONArray;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;

import java.sql.*;

/**
 * 説明：
 *
 */
public class ResultSetConverter {
    
    public static JSONArray convert( ResultSet rs )
            throws SQLException, JSONException {
        
        JSONArray json = new JSONArray();
        ResultSetMetaData rsmd = rs.getMetaData();

        while(rs.next()) {
            int numColumns = rsmd.getColumnCount();
            JSONObject obj = new JSONObject();

            for (int i=1; i<numColumns+1; i++) {
                String column_name = rsmd.getColumnName(i);

                if(rsmd.getColumnType(i)==java.sql.Types.ARRAY){
                    obj.put(column_name, rs.getArray(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.BIGINT){
                    obj.put(column_name, rs.getInt(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.BOOLEAN){
                    obj.put(column_name, rs.getBoolean(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.BLOB){
                    obj.put(column_name, rs.getBlob(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.DOUBLE){
                    obj.put(column_name, rs.getDouble(column_name)); 
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.FLOAT){
                    obj.put(column_name, rs.getFloat(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
                    obj.put(column_name, rs.getInt(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.NVARCHAR){
                    obj.put(column_name, rs.getNString(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
                    obj.put(column_name, rs.getString(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.TINYINT){
                    obj.put(column_name, rs.getInt(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.SMALLINT){
                    obj.put(column_name, rs.getInt(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.DATE){
                    obj.put(column_name, rs.getDate(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.TIMESTAMP){
                    obj.put(column_name, rs.getTimestamp(column_name));   
                }
                else{
                    obj.put(column_name, rs.getObject(column_name));
                }
            }

            json.put(obj);
        }

        return json;
          
    }
    
    public static StringBuffer convertCsv( ResultSet rs ) 
        throws SQLException {
        
        String column_name     = new String();
        StringBuffer retval    = new StringBuffer();
        ResultSetMetaData rsmd = rs.getMetaData();
        int numColumns         = rsmd.getColumnCount();
        
        for( int h=1; h<numColumns+1; h++ ) {
            column_name = rsmd.getColumnName(h);
            
            if( h > 1 ) {
                retval.append(",");
            }
            
            retval.append(column_name);
        }
        retval.append("\n");
        
        while( rs.next() ) {
                        
            for( int i=1; i<numColumns+1; i++ ) {
                column_name = rsmd.getColumnName(i);
                
                if(StringUtils.equals(column_name, "the_geom") ) {
                    continue;
                }                 
                if(StringUtils.equals(column_name, "geojson") ) {
                    continue;
                }
                if( i > 1 ) {
                    retval.append(",");
                }
                
                if(rsmd.getColumnType(i)==java.sql.Types.ARRAY){
                     retval.append( rs.getArray(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.BIGINT){
                     retval.append( rs.getInt(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.BOOLEAN){
                     retval.append( rs.getBoolean(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.BLOB){
                     retval.append( rs.getBlob(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.DOUBLE){
                     retval.append( rs.getDouble(column_name)); 
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.FLOAT){
                     retval.append( rs.getFloat(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
                     retval.append( rs.getInt(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.NVARCHAR){
                     retval.append( rs.getNString(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
                     retval.append( rs.getString(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.TINYINT){
                     retval.append( rs.getInt(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.SMALLINT){
                     retval.append( rs.getInt(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.DATE){
                     retval.append( rs.getDate(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.TIMESTAMP){
                     retval.append( rs.getTimestamp(column_name));   
                }
                else{
                     retval.append( rs.getObject(column_name));
                }

            }
            retval.append("\n");
        }
        
        return retval;
    }
    public static JSONArray convertGeoJson( ResultSet rs )
            throws SQLException, JSONException {
        
        JSONArray json = new JSONArray();
        ResultSetMetaData rsmd = rs.getMetaData();

        while(rs.next()) {
            int numColumns  = rsmd.getColumnCount();
            JSONObject obj  = new JSONObject();
            JSONObject feat = new JSONObject();

            feat.put("type", "Feature");
            
            for (int i=1; i<numColumns+1; i++) {
                String column_name = rsmd.getColumnName(i);

                if(StringUtils.equals(column_name, "the_geom") ) {
                    continue;
                }                 
                if(StringUtils.equals(column_name, "geojson") ) {
                    continue;
                }
                if(rsmd.getColumnType(i)==java.sql.Types.ARRAY){
                    obj.put(column_name, rs.getArray(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.BIGINT){
                    obj.put(column_name, rs.getInt(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.BOOLEAN){
                    obj.put(column_name, rs.getBoolean(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.BLOB){
                    obj.put(column_name, rs.getBlob(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.DOUBLE){
                    obj.put(column_name, rs.getDouble(column_name)); 
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.FLOAT){
                    obj.put(column_name, rs.getFloat(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
                    obj.put(column_name, rs.getInt(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.NVARCHAR){
                    obj.put(column_name, rs.getNString(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
                    obj.put(column_name, rs.getString(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.TINYINT){
                    obj.put(column_name, rs.getInt(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.SMALLINT){
                    obj.put(column_name, rs.getInt(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.DATE){
                    obj.put(column_name, rs.getDate(column_name));
                }
                else if(rsmd.getColumnType(i)==java.sql.Types.TIMESTAMP){
                    obj.put(column_name, rs.getTimestamp(column_name));   
                }
                else{
                    obj.put(column_name, rs.getObject(column_name));
                }
            }

            feat.put("properties", obj);
            
            try {
                rs.findColumn("lon");
                rs.findColumn("lat");
                
                JSONObject geo  = new JSONObject();
                JSONArray coord = new JSONArray();
                
                coord.put(rs.getDouble("lon"));
                coord.put(rs.getDouble("lat"));
                
                geo.put("type", "point");
                geo.put("coordinates", coord);
                
                feat.put("geometry", geo );
            }
            catch(Exception ex1 ) {
                ;
            }
            
            json.put(feat);
        }

        return json;
          
    }

}
