package com.challenge.utils.config;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

//Clase de utilidad que se encarga de leer las variables de entorno como la urlBase desde el archivo serenity.conf
 
public class EnvironmentConfig {

    private static EnvironmentVariables environmentVariables;

   public static void setVariables(EnvironmentVariables variables) {
        environmentVariables = variables;
    }

    public static String getProperty(String name) {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty(name);
    }
//Metodo que obtiene la url base
    public static String urlBase() {
        return getProperty("urlBase");
    }
}
