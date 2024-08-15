package com.ro.portfolio.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Data Config class to handle CORS error from web app
 */
@Data
@ConfigurationProperties("application")
public class ApplicationProperties {
    // Cors Instance to handle cross server activity
    public Cors cors = new Cors();

    /**
     * Cors Object to handle cors error in web application
     */
    @Data
    public static class Cors{
        private String pathPattern = "/api/**";
        private String allowedMethods = "*";
        private String allowedHeaders = "*";
        private String allowedOriginPatterns ="*";
        private boolean allowCredentials = true;
    }
}
