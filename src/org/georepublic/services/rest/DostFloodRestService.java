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

import org.apache.wink.json4j.JSONObject;
import org.georepublic.db.DBProc;

/**
 * 説明：
 *
 */
@Path("/")
public class DostFloodRestService {

    @GET
    public String emptyReq() {
        return "<b>error</b>: empty Request";
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("/weatherstation/json")
    @GET
    public String aws_json(
            @QueryParam("id")    String id,
            @QueryParam("start") String start,
            @QueryParam("end")   String end ) {
        
        String retval = null;
        JSONObject jo = new JSONObject();
        
        String sql = "select name,time::text,temp,humi,pres,rain,lon,lat from aws where name = ? and time >=  ? and time <= ?";
        
        try {
            DBProc dbProc = new DBProc();
            
            jo.put( "Features", dbProc.sensorJson(sql,id,start,end) );
            
            retval = jo.toString();
        }
        catch( Exception e ) {
            ;
        }
        return retval;
    }
    
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/weatherstation/csv")
    @GET
    public String aws_csv(
            @QueryParam("id")    String id,
            @QueryParam("start") String start,
            @QueryParam("end")   String end ) {
        
        String retval = null;
        String sql = "select name,time::text,temp,humi,pres,rain,lon,lat from aws where name = ? and time >=  ? and time <= ?";
        
        try {
            DBProc dbProc   = new DBProc();
            StringBuffer sb = dbProc.sensorCsv(sql,id, start, end);
            
            retval = sb.toString();
        }
        catch( Exception e ) {
            ;
        }
        return retval;
    }    

    @Produces(MediaType.APPLICATION_JSON)
    @Path("/rainfall/json")
    @GET
    public String arg_json(
            @QueryParam("id")    String id,
            @QueryParam("start") String start,
            @QueryParam("end")   String end ) {
        
        String retval = null;
        JSONObject jo = new JSONObject();
        
        String sql = "select name,time::text,value as rainfall,lon,lat from arg where name = ? and time >=  ? and time <= ?";
        
        try {
            DBProc dbProc = new DBProc();
            
            jo.put( "Features", dbProc.sensorJson(sql,id,start,end) );
            
            retval = jo.toString();
        }
        catch( Exception e ) {
            ;
        }
        return retval;
    }
    
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/rainfall/csv")
    @GET
    public String arg_csv(
            @QueryParam("id")    String id,
            @QueryParam("start") String start,
            @QueryParam("end")   String end ) {
        
        String retval = null;
        String sql = "select name,time::text,value as rainfall,lon,lat from arg where name = ? and time >=  ? and time <= ?";
        
        try {
            DBProc dbProc   = new DBProc();
            StringBuffer sb = dbProc.sensorCsv(sql,id, start, end);
            
            retval = sb.toString();
        }
        catch( Exception e ) {
            ;
        }
        return retval;
    }    

    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tideguage/json")
    @GET
    public String td_json(
            @QueryParam("id")    String id,
            @QueryParam("start") String start,
            @QueryParam("end")   String end ) {
        
        String retval = null;
        JSONObject jo = new JSONObject();
        
        String sql = "select name,time::text,sunrise::text,sunset::text,moonrise::text,moonset::text,value,water_level_change,time_difference,lon,lat from td where name = ? and time >=  ? and time <= ?";
        
        try {
            DBProc dbProc = new DBProc();
            
            jo.put( "Features", dbProc.sensorJson(sql,id,start,end) );
            
            retval = jo.toString();
        }
        catch( Exception e ) {
            ;
        }
        return retval;
    }
    
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/tideguage/csv")
    @GET
    public String td_csv(
            @QueryParam("id")    String id,
            @QueryParam("start") String start,
            @QueryParam("end")   String end ) {
        
        String retval = null;
        String sql = "select name,time::text,sunrise::text,sunset::text,moonrise::text,moonset::text,value,water_level_change,time_difference,lon,lat from td where name = ? and time >=  ? and time <= ?";
        
        try {
            DBProc dbProc   = new DBProc();
            StringBuffer sb = dbProc.sensorCsv(sql,id, start, end);
            
            retval = sb.toString();
        }
        catch( Exception e ) {
            ;
        }
        return retval;
    }    

    @Produces(MediaType.APPLICATION_JSON)
    @Path("/streamguage/json")
    @GET
    public String asg_json(
            @QueryParam("id")    String id,
            @QueryParam("start") String start,
            @QueryParam("end")   String end ) {
        
        String retval = null;
        JSONObject jo = new JSONObject();
        
        String sql = "select name,time::text,value,water_level_change,time_difference,lon,lat from asg where name = ? and time >=  ? and time <= ?";
        
        try {
            DBProc dbProc = new DBProc();
            
            jo.put( "Features", dbProc.sensorJson(sql,id,start,end) );
            
            retval = jo.toString();
        }
        catch( Exception e ) {
            ;
        }
        return retval;
    }
    
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/streamguage/csv")
    @GET
    public String asg_csv(
            @QueryParam("id")    String id,
            @QueryParam("start") String start,
            @QueryParam("end")   String end ) {
        
        String retval = null;
        String sql = "select name,time::text,value,water_level_change,time_difference,lon,lat from asg where name = ? and time >=  ? and time <= ?";
        
        try {
            DBProc dbProc   = new DBProc();
            StringBuffer sb = dbProc.sensorCsv(sql,id, start, end);
            
            retval = sb.toString();
        }
        catch( Exception e ) {
            ;
        }
        return retval;
    }    

}
