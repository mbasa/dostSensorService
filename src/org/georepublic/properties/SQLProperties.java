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

/**
 * 説明：
 *
 */
public class SQLProperties {
    
    private static String awsSql = null;
    private static String argSql = null;
    private static String asgSql = null;
    private static String tdSql  = null;

    private static String awsListSql = null;
    private static String argListSql = null;
    private static String asgListSql = null;
    private static String tdListSql  = null;

    private static String awsAggrSql = null;
    private static String argAggrSql = null;
    private static String asgAggrSql = null;
    private static String tdAggrSql  = null;

    public static void setProperties(){
        
        ResourceBundle resb = 
                ResourceBundle.getBundle("properties.sql");
        
        setAwsSql(resb.getString("AWS_SQL"));
        setArgSql(resb.getString("ARG_SQL"));
        setAsgSql(resb.getString("ASG_SQL"));
        setTdSql(resb.getString("TD_SQL"));
        
        setAwsListSql(resb.getString("AWS_LIST_SQL"));
        setArgListSql(resb.getString("ARG_LIST_SQL"));
        setAsgListSql(resb.getString("ASG_LIST_SQL"));
        setTdListSql(resb.getString("TD_LIST_SQL"));
        
        setAwsAggrSql(resb.getString("AWS_AGGR_SQL"));
        setArgAggrSql(resb.getString("ARG_AGGR_SQL"));
        setAsgAggrSql(resb.getString("ASG_AGGR_SQL"));
        setTdAggrSql(resb.getString("TD_AGGR_SQL"));
    }
    /**
     * @return awsSql を取得する
     */
    public static String getAwsSql() {
        return awsSql;
    }
    /**
     * @param awsSql awsSql を設定する
     */
    public static void setAwsSql(String awsSql) {
        SQLProperties.awsSql = awsSql;
    }
    /**
     * @return argSql を取得する
     */
    public static String getArgSql() {
        return argSql;
    }
    /**
     * @param argSql argSql を設定する
     */
    public static void setArgSql(String argSql) {
        SQLProperties.argSql = argSql;
    }
    /**
     * @return asgSql を取得する
     */
    public static String getAsgSql() {
        return asgSql;
    }
    /**
     * @param asgSql asgSql を設定する
     */
    public static void setAsgSql(String asgSql) {
        SQLProperties.asgSql = asgSql;
    }
    /**
     * @return tdSql を取得する
     */
    public static String getTdSql() {
        return tdSql;
    }
    /**
     * @param tdSql tdSql を設定する
     */
    public static void setTdSql(String tdSql) {
        SQLProperties.tdSql = tdSql;
    }
    /**
     * @return awsListSql を取得する
     */
    public static String getAwsListSql() {
        return awsListSql;
    }
    /**
     * @param awsListSql awsListSql を設定する
     */
    public static void setAwsListSql(String awsListSql) {
        SQLProperties.awsListSql = awsListSql;
    }
    /**
     * @return argListSql を取得する
     */
    public static String getArgListSql() {
        return argListSql;
    }
    /**
     * @param argListSql argListSql を設定する
     */
    public static void setArgListSql(String argListSql) {
        SQLProperties.argListSql = argListSql;
    }
    /**
     * @return asgListSql を取得する
     */
    public static String getAsgListSql() {
        return asgListSql;
    }
    /**
     * @param asgListSql asgListSql を設定する
     */
    public static void setAsgListSql(String asgListSql) {
        SQLProperties.asgListSql = asgListSql;
    }
    /**
     * @return tdListSql を取得する
     */
    public static String getTdListSql() {
        return tdListSql;
    }
    /**
     * @param tdListSql tdListSql を設定する
     */
    public static void setTdListSql(String tdListSql) {
        SQLProperties.tdListSql = tdListSql;
    }
    /**
     * @return awsAggrSql を取得する
     */
    public static String getAwsAggrSql() {
        return awsAggrSql;
    }
    /**
     * @param awsAggrSql awsAggrSql を設定する
     */
    public static void setAwsAggrSql(String awsAggrSql) {
        SQLProperties.awsAggrSql = awsAggrSql;
    }
    /**
     * @return argAggrSql を取得する
     */
    public static String getArgAggrSql() {
        return argAggrSql;
    }
    /**
     * @param argAggrSql argAggrSql を設定する
     */
    public static void setArgAggrSql(String argAggrSql) {
        SQLProperties.argAggrSql = argAggrSql;
    }
    /**
     * @return asgAggrSql を取得する
     */
    public static String getAsgAggrSql() {
        return asgAggrSql;
    }
    /**
     * @param asgAggrSql asgAggrSql を設定する
     */
    public static void setAsgAggrSql(String asgAggrSql) {
        SQLProperties.asgAggrSql = asgAggrSql;
    }
    /**
     * @return tdAggrSql を取得する
     */
    public static String getTdAggrSql() {
        return tdAggrSql;
    }
    /**
     * @param tdAggrSql tdAggrSql を設定する
     */
    public static void setTdAggrSql(String tdAggrSql) {
        SQLProperties.tdAggrSql = tdAggrSql;
    }

}
