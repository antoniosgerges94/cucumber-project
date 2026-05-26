package com.qacart.todo.utils;

import java.io.IOException;
import java.util.Properties;

public class EnvUtils {

    private Properties prop;

    private static EnvUtils envUtils;

    private EnvUtils() throws IOException {

        String env = System.getProperty("env", "STAGING");

        switch (env) {
            case "PRODUCTION":
                prop = ConfigUtil.readConfig("src/test/resources/properties/production.properties");
                break;

            case "STAGING":
                prop = ConfigUtil.readConfig("src/test/resources/properties/staging.properties");
                break;

            case "LOCAL":
                prop = ConfigUtil.readConfig("src/test/resources/properties/local.properties");
                break;
                default:
                    throw new RuntimeException("Environment is not supported");
    }
}

    public static EnvUtils getInstance() throws IOException {

        envUtils = new EnvUtils();

        return envUtils;

    }

    public String getURL(){
        return prop.get("URL").toString();
    }

    public String getEmail(){
        return prop.get("EMAIL").toString();
    }

    public String getPassword(){
        return prop.get("PASSWORD").toString();
    }
}
