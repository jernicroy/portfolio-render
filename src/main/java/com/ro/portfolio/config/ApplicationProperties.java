package com.ro.portfolio.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties("application")
public class ApplicationProperties {
    public Cors cors = new Cors();

    @Data
    public static class Cors{
        private String pathPattern = "/api/**";
        private String allowedMethods = "*";
        private String allowedHeaders = "*";
        private String allowedOriginPatterns ="*";
        private boolean allowCredentials = true;
    }
}
