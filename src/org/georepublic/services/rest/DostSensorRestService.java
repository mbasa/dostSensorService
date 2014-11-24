/**
 * パッケージ名：org.georepublic.services.rest
 * ファイル名  ：DostFloodRestService.java
 * 
 * @author mbasa
 * @since Nov 16, 2014
 */
package org.georepublic.services.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.apache.wink.json4j.JSONObject;
import org.georepublic.db.DBProc;
import org.georepublic.properties.SQLProperties;

/**
 * 説明：
 *
 */
@Path("/")
public class DostSensorRestService {

    @GET
    public String emptyReq() {
        return "<b>error</b>: empty Request";
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{sensor}/json")
    @GET
    public String aws_json(
            @PathParam("sensor") String sensor,
            @QueryParam("id")    String id,
            @QueryParam("start") String start,
            @QueryParam("end")   String end ) {
        
        String retval  = null;
        String sql     = new String();
        String sqlList = new String();
        JSONObject jo  = new JSONObject();
                        
        if( StringUtils.equalsIgnoreCase(sensor, "weatherstation")) {
            sql     = SQLProperties.getAwsSql();
            sqlList = SQLProperties.getAwsListSql();
        }
        else if( StringUtils.equalsIgnoreCase(sensor, "rainfall")) {
            sql     = SQLProperties.getArgSql();
            sqlList = SQLProperties.getArgListSql();
        }
        else if( StringUtils.equalsIgnoreCase(sensor, "tideguage")) {
            sql     = SQLProperties.getTdSql();
            sqlList = SQLProperties.getTdListSql();
        }
        else if( StringUtils.equalsIgnoreCase(sensor, "streamguage")) {
            sql     = SQLProperties.getAsgSql();
            sqlList = SQLProperties.getAsgListSql();
        }
        else {           
            return this.emptyReq();
        }
        
        try {
            DBProc dbProc = new DBProc();
            
            if( id != null && start != null && end != null ) {
                jo.put( "Features", dbProc.sensorJson(sql,id,start,end) );
            }
            else {
                jo.put( "Features", dbProc.sensorListJson(sqlList,id,start,end) );
            }
            
            retval = jo.toString();
        }
        catch( Exception e ) {
            ;
        }
        return retval;
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{sensor}/csv")
    @GET
    public String aws_csv(
            @PathParam("sensor") String sensor,
            @QueryParam("id")    String id,
            @QueryParam("start") String start,
            @QueryParam("end")   String end ) {
        
        String retval  = null;
        String sql     = new String(); 
        String sqlList = new String();
        
        if( StringUtils.equalsIgnoreCase(sensor, "weatherstation")) {
            sql     = SQLProperties.getAwsSql();
            sqlList = SQLProperties.getAwsListSql();
        }
        else if( StringUtils.equalsIgnoreCase(sensor, "rainfall")) {
            sql     = SQLProperties.getArgSql();
            sqlList = SQLProperties.getArgListSql();
        }
        else if( StringUtils.equalsIgnoreCase(sensor, "tideguage")) {
            sql     = SQLProperties.getTdSql();
            sqlList = SQLProperties.getTdListSql();
        }
        else if( StringUtils.equalsIgnoreCase(sensor, "streamguage")) {
            sql     = SQLProperties.getAsgSql();
            sqlList = SQLProperties.getAsgListSql();
        }
        else {           
            return this.emptyReq();
        }

        try {
            DBProc dbProc   = new DBProc();
            StringBuffer sb = new StringBuffer();
            
            if( id != null && start != null && end != null ) {
                sb = dbProc.sensorCsv(sql,id, start, end);
            }
            else {
                sb = dbProc.sensorListCsv(sqlList,id, start, end);
            }
            
            retval = sb.toString();
        }
        catch( Exception e ) {
            ;
        }
        return retval;
    }    
}
