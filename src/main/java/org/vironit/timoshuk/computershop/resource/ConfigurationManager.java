package org.vironit.timoshuk.computershop.resource;

import java.util.ResourceBundle;

public class ConfigurationManager {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("config");

    public ConfigurationManager (){}

    public static String getProperty (String key){
        return RESOURCE_BUNDLE.getString(key);
    }
}
