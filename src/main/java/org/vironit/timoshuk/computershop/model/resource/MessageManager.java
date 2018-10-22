package org.vironit.timoshuk.computershop.model.resource;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("message", new Locale("",""));

    public static void checkLocale (Locale locale){
        resourceBundle = ResourceBundle.getBundle("message", locale);
    }

    private MessageManager (){}

    public static String getProperty (String key){
        return resourceBundle.getString(key);
    }
}
