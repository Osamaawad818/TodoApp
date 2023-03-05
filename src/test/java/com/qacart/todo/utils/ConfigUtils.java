package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils(){
//        properties = PropertiesUtil
//                .loadProperties("src/test/java/com/qacart/todo/config/production.properties");
        String env = System.getProperty("env" , "production");
        switch (env) {
            case "PRODUCTION" :
                properties = PropertiesUtil
                        .loadProperties("src/test/java/com/qacart/todo/config/production.properties");
                break;

            case "LOCAL":
                properties = PropertiesUtil
                        .loadProperties("src/test/java/com/qacart/todo/config/local.properties");
                break;

            default:
//                throw new RuntimeException("Environment is NOT supported");
                System.out.println("Find an ENV");
                properties = PropertiesUtil
                        .loadProperties("src/test/java/com/qacart/todo/config/production.properties");
        }
    }

    public static ConfigUtils getInstance() {
        if(configUtils == null){
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        throw new RuntimeException("Could not find the BASEURL in the prop file");
    }

    public String getEmail() {
        String prop = properties.getProperty("email");
        if(prop != null) return prop;
        throw new RuntimeException("Could not find the EMAIL in the prop file");
    }

    public String getPassword() {
        String prop = properties.getProperty("password");
        if(prop != null) return prop;
        throw new RuntimeException("Could not find the password in the prop file");
    }
}
