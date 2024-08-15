package com.ro.portfolio.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMVCConfig class to handle the CORS issue from browser
 */
@Configuration
@RequiredArgsConstructor
public class WebMVCConfig implements WebMvcConfigurer {

    private final ApplicationProperties properties;

    /**
     * Initializing the cors registry
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(properties.getCors().getPathPattern())
                .allowedMethods(properties.getCors().getAllowedMethods())
                .allowedHeaders(properties.getCors().getAllowedHeaders())
                .allowedOriginPatterns(properties.getCors().getAllowedOriginPatterns())
                .allowCredentials(properties.getCors().isAllowCredentials());
    }
}
