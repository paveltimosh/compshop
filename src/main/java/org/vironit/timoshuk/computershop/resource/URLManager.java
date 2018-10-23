package org.vironit.timoshuk.computershop.resource;

import java.util.ResourceBundle;

public class URLManager {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("urlConfig");

    public URLManager (){}

    public static String getProperty (String key){
        return RESOURCE_BUNDLE.getString(key);
    }
}
