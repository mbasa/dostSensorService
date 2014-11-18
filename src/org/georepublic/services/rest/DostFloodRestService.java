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

import org.apache.wink.json4j.JSONArray;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;

import org.georepublic.db.DBProc;
import org.georepublic.properties.*;

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
    @Path("/rainfall/json")
    @GET
    public String rain_json(
            @QueryParam("id")    String id,
            @QueryParam("start") String start,
            @QueryParam("end")   String end ) {
        
        String retval = null;
        JSONObject jo = new JSONObject();
        
        try {
            DBProc dbProc = new DBProc();
            
            jo.put("Features", dbProc.rainJson(id, start, end));
            
            retval = jo.toString();
        }
        catch( Exception e ) {
            ;
        }
        return retval;
    }    
}
