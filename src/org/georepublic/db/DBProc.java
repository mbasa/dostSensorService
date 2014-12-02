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

package org.georepublic.db;

import java.sql.*;

import org.apache.wink.json4j.JSONArray;
import org.georepublic.db.utils.ResultSetConverter;

/**
 * 説明： Database Procedures
 *
 */
public class DBProc {

    DBConn dbConn = null;

    public DBProc() {		
        this.dbConn = new DBConn();
    }

    public JSONArray sensorJson(
            String sql,String id,String start,String end) {
        
        JSONArray retval = null;
                
        Connection conn = dbConn.getConnection();

        if( this.dbConn != null ) {
            PreparedStatement stmnt = null;
            ResultSet rs = null;
            
            try {
                stmnt = conn.prepareStatement(sql);
                stmnt.setString(1, id  );
                stmnt.setTimestamp(2, Timestamp.valueOf(start) );
                
                if( end != null ) {
                    stmnt.setTimestamp(3, Timestamp.valueOf(end) );
                }
                else {
                    stmnt.setTimestamp(3, getCurrentTimeStamp() );
                }

                rs = stmnt.executeQuery();
                retval = ResultSetConverter.convertGeoJson(rs);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if( rs != null ) {
                        rs.close();
                    }
                    if( stmnt != null ) {
                        stmnt.close();
                    }
                    if( conn != null ) {
                        //conn.commit();
                        conn.close();
                    }
                }
                catch( Exception ex ) {;}
            }
        }

        return retval;
    }

    public JSONArray sensorListJson(
            String sql,String id,String start,String end) {
        
        JSONArray retval = null;
                
        Connection conn = dbConn.getConnection();

        if( this.dbConn != null ) {
            PreparedStatement stmnt = null;
            ResultSet rs = null;
            
            try {
                stmnt  = conn.prepareStatement(sql);
                rs     = stmnt.executeQuery();
                retval = ResultSetConverter.convertGeoJson(rs);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if( rs != null ) {
                        rs.close();
                    }
                    if( stmnt != null ) {
                        stmnt.close();
                    }
                    if( conn != null ) {
                        //conn.commit();
                        conn.close();
                    }
                }
                catch( Exception ex ) {;}
            }
        }

        return retval;
    }

    public JSONArray sensorBboxJson(
            String sql,String bbox,String start,String end) {
        
        JSONArray retval = null;
                
        Connection conn = dbConn.getConnection();

        if( this.dbConn != null ) {
            PreparedStatement stmnt = null;
            ResultSet rs = null;
            
            try {
                stmnt  = conn.prepareStatement(sql);
                
                String st[] = bbox.split(",");
                
                if( st.length != 4 ) {
                    return retval;
                }
                
                stmnt.setDouble(1, Double.parseDouble(st[0]));
                stmnt.setDouble(2, Double.parseDouble(st[1]));
                stmnt.setDouble(3, Double.parseDouble(st[2]));
                stmnt.setDouble(4, Double.parseDouble(st[3]));
                stmnt.setTimestamp(5, Timestamp.valueOf(start));
                stmnt.setTimestamp(6, Timestamp.valueOf(end));

                rs     = stmnt.executeQuery();
                retval = ResultSetConverter.convertGeoJson(rs);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if( rs != null ) {
                        rs.close();
                    }
                    if( stmnt != null ) {
                        stmnt.close();
                    }
                    if( conn != null ) {
                        //conn.commit();
                        conn.close();
                    }
                }
                catch( Exception ex ) {;}
            }
        }

        return retval;
    }

    public StringBuffer sensorCsv(
            String sql,String id,String start,String end) {
        
        StringBuffer retval = new StringBuffer();
        
        Connection conn = dbConn.getConnection();

        if( this.dbConn != null ) {
            PreparedStatement stmnt = null;
            ResultSet rs = null;
            
            try {
                stmnt = conn.prepareStatement(sql);
                stmnt.setString(1, id  );
                stmnt.setTimestamp(2, Timestamp.valueOf(start) );
                
                if( end != null ) {
                    stmnt.setTimestamp(3, Timestamp.valueOf(end) );
                }
                else {
                    stmnt.setTimestamp(3, getCurrentTimeStamp() );
                }

                rs     = stmnt.executeQuery();
                retval = ResultSetConverter.convertCsv(rs);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if( rs != null ) {
                        rs.close();
                    }
                    if( stmnt != null ) {
                        stmnt.close();
                    }
                    if( conn != null ) {
                        //conn.commit();
                        conn.close();
                    }
                }
                catch( Exception ex ) {;}
            }
        }

        return retval;
    }

    public StringBuffer sensorListCsv(
            String sql,String id,String start,String end) {
        
        StringBuffer retval = new StringBuffer();
        
        Connection conn = dbConn.getConnection();

        if( this.dbConn != null ) {
            PreparedStatement stmnt = null;
            ResultSet rs = null;
            
            try {
                stmnt  = conn.prepareStatement(sql);
                rs     = stmnt.executeQuery();
                retval = ResultSetConverter.convertCsv(rs);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if( rs != null ) {
                        rs.close();
                    }
                    if( stmnt != null ) {
                        stmnt.close();
                    }
                    if( conn != null ) {
                        //conn.commit();
                        conn.close();
                    }
                }
                catch( Exception ex ) {;}
            }
        }

        return retval;
    }

    public StringBuffer sensorBboxCsv(
            String sql,String bbox,String start,String end) {
        
        StringBuffer retval = new StringBuffer();
        
        Connection conn = dbConn.getConnection();

        if( this.dbConn != null ) {
            PreparedStatement stmnt = null;
            ResultSet rs = null;
            
            try {
                stmnt  = conn.prepareStatement(sql);
                
                String st[] = bbox.split(",");
                
                if( st.length != 4 ) {
                    return retval;
                }
                
                stmnt.setDouble(1, Double.parseDouble(st[0]));
                stmnt.setDouble(2, Double.parseDouble(st[1]));
                stmnt.setDouble(3, Double.parseDouble(st[2]));
                stmnt.setDouble(4, Double.parseDouble(st[3]));
                stmnt.setTimestamp(5, Timestamp.valueOf(start));
                stmnt.setTimestamp(6, Timestamp.valueOf(end));
                
                rs     = stmnt.executeQuery();
                retval = ResultSetConverter.convertCsv(rs);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if( rs != null ) {
                        rs.close();
                    }
                    if( stmnt != null ) {
                        stmnt.close();
                    }
                    if( conn != null ) {
                        //conn.commit();
                        conn.close();
                    }
                }
                catch( Exception ex ) {;}
            }
        }

        return retval;
    }

    public java.sql.Timestamp getCurrentTimeStamp() {
        
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
     
    }
}
