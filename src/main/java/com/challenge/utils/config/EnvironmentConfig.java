package com.challenge.utils.config;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

public class EnvironmentConfig {

    private static EnvironmentVariables environmentVariables;


    public static void setVariables(EnvironmentVariables variables) {
        environmentVariables = variables;
    }

    public static String getProperty(String name) {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty(name);
    }

    public static String urlBase() {
        return getProperty("urlBase");
    }
}
