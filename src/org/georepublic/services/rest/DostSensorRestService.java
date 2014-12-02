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
            @QueryParam("end")   String end,
            @QueryParam("type")  String type,
            @QueryParam("bbox")  String bbox ) {
        
        String retval  = null;
        String sql     = new String();
        String sqlAggr = new String();
        String sqlList = new String();
        String sqlBbox = new String();
        JSONObject jo  = new JSONObject();
                        
        if( StringUtils.equalsIgnoreCase(sensor, "weatherstation")) {
            sql     = SQLProperties.getAwsSql();
            sqlAggr = SQLProperties.getAwsAggrSql();
            sqlList = SQLProperties.getAwsListSql();
            sqlBbox = SQLProperties.getAwsBboxSql();
        }
        else if( StringUtils.equalsIgnoreCase(sensor, "rainfall")) {
            sql     = SQLProperties.getArgSql();
            sqlAggr = SQLProperties.getArgAggrSql();
            sqlList = SQLProperties.getArgListSql();
            sqlBbox = SQLProperties.getArgBboxSql();
        }
        else if( StringUtils.equalsIgnoreCase(sensor, "tideguage")) {
            sql     = SQLProperties.getTdSql();
            sqlAggr = SQLProperties.getTdAggrSql();
            sqlList = SQLProperties.getTdListSql();
            sqlBbox = SQLProperties.getTdBboxSql();
        }
        else if( StringUtils.equalsIgnoreCase(sensor, "streamguage")) {
            sql     = SQLProperties.getAsgSql();
            sqlAggr = SQLProperties.getAsgAggrSql();
            sqlList = SQLProperties.getAsgListSql();
            sqlBbox = SQLProperties.getAsgBboxSql();
        }
        else {           
            return this.emptyReq();
        }
        
        try {
            DBProc dbProc = new DBProc();
            
            if( bbox != null && start != null && end != null ) {
                jo.put( "Features", dbProc.sensorBboxJson(sqlBbox,bbox,start,end) );
            }
            else if( id != null && start != null ) {
                if( StringUtils.equalsIgnoreCase(type, "aggregate") ) {
                    jo.put( "Features", dbProc.sensorJson(sqlAggr,id,start,end) );
                }
                else {
                    jo.put( "Features", dbProc.sensorJson(sql,id,start,end) );
                }
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
            @QueryParam("end")   String end,
            @QueryParam("type")  String type,
            @QueryParam("bbox")  String bbox) {
        
        String retval  = null;
        String sql     = new String(); 
        String sqlAggr = new String();
        String sqlList = new String();
        String sqlBbox = new String();
        
        if( StringUtils.equalsIgnoreCase(sensor, "weatherstation")) {
            sql     = SQLProperties.getAwsSql();
            sqlAggr = SQLProperties.getAwsAggrSql();
            sqlList = SQLProperties.getAwsListSql();
            sqlBbox = SQLProperties.getAwsBboxSql();
        }
        else if( StringUtils.equalsIgnoreCase(sensor, "rainfall")) {
            sql     = SQLProperties.getArgSql();
            sqlAggr = SQLProperties.getArgAggrSql();
            sqlList = SQLProperties.getArgListSql();
            sqlBbox = SQLProperties.getArgBboxSql();
        }
        else if( StringUtils.equalsIgnoreCase(sensor, "tideguage")) {
            sql     = SQLProperties.getTdSql();
            sqlAggr = SQLProperties.getTdAggrSql();
            sqlList = SQLProperties.getTdListSql();
            sqlBbox = SQLProperties.getTdBboxSql();
        }
        else if( StringUtils.equalsIgnoreCase(sensor, "streamguage")) {
            sql     = SQLProperties.getAsgSql();
            sqlAggr = SQLProperties.getAsgAggrSql();
            sqlList = SQLProperties.getAsgListSql();
            sqlBbox = SQLProperties.getAsgBboxSql();
        }
        else {           
            return this.emptyReq();
        }

        try {
            DBProc dbProc   = new DBProc();
            StringBuffer sb = new StringBuffer();
            
            if( bbox != null && start != null && end != null ) {
                sb = dbProc.sensorBboxCsv(sqlBbox, bbox, start, end);
            }
            else if( id != null && start != null  ) {
                if( StringUtils.equalsIgnoreCase(type, "aggregate") ) {
                    sb = dbProc.sensorCsv(sqlAggr,id, start, end);
                }
                else {
                    sb = dbProc.sensorCsv(sql,id, start, end);
                }
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
