/**
 * パッケージ名：org.georepublic.db
 * ファイル名  ：DBProc.java
 * 
 * @author mbasa
 * @since Nov 16, 2014
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

    public java.sql.Timestamp getCurrentTimeStamp() {
        
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());
     
    }
}
