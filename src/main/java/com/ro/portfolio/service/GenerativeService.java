package com.ro.portfolio.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Slf4j
@Service
public class GenerativeService {

    @Value("${GEMINI_API_URL}")
    private String GEMINI_API_URL;
    @Value("${GEMINI_AI_KEY}")
    private String API_KEY;

    private final WebClient webClient;

    public GenerativeService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<Map> askGemini(String question) {
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[] { Map.of("parts", new Object[] { Map.of("text", question) }) }
        );

        return webClient.post()
                .uri(GEMINI_API_URL+API_KEY)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class);
    }
}
