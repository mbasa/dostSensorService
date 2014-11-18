/**
 * パッケージ名：org.georepublic.services.rest
 * ファイル名  ：DostFloodApplication.java
 * 
 * @author mbasa
 * @since Nov 16, 2014
 */
package org.georepublic.services.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.georepublic.properties.DBProperties;

/**
 * 説明： Wink Application(s) Loader
 *
 */
public class DostFloodApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add( DostFloodRestService.class );
        
        //::::::::::::::::::::::::::
        //: Setting the properties
        //::::::::::::::::::::::::::
        DBProperties.setProperties();
        
        return classes;
    }
}