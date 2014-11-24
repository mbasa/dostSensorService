/**
 * パッケージ名：org.georepublic.properties
 * ファイル名  ：SQLProperties.java
 * 
 * @author mbasa
 * @since Nov 20, 2014
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

}
