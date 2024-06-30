package com.ro.portfolio.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @Description : Component to prevent application from spin down in the server
 *
 */
@Component
@EnableScheduling
public class AliveService {
    private final WebClient webClient;
    @Value("${spring.app.base.url}")
    private String baseUrl;

    private static final Logger log = LoggerFactory.getLogger(AliveService.class);
    public AliveService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Scheduled(fixedRate = 60000) // Every 60 seconds
    public void keepAlive() {
        String healthCheckUrl = baseUrl + "api/pinch";
        log.info(" Health check URL: "+ healthCheckUrl);
        Mono<String> result = webClient.get()
                .uri(healthCheckUrl)
                .retrieve()
                .bodyToMono(String.class);

        result.subscribe(
                response -> {
                    // Handle successful response
                    log.info("Health check response: " + response);
                },
                error -> {
                    // Handle error
                    log.error("Error during health check: " + error.getMessage());
                }
        );
    }
}
