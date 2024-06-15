package com.ro.portfolio.service;

import com.ro.portfolio.entity.VisitorsInfo;
import com.ro.portfolio.repo.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class VisitorService {
    @Autowired
    VisitorRepository visitorRepository;

    private final WebClient webClient;

    public VisitorService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://ipinfo.io").build();
    }

    private VisitorsInfo saveVisitors (VisitorsInfo visitorsInfo){
        return visitorRepository.save(visitorsInfo);
    }

    public VisitorsInfo fetchAndSaveProject() {
        Mono<VisitorsInfo> visitorMono = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/json")
                        .queryParam("token", "4565fcbc9f62b5")
                        .build())
                .retrieve()
                .bodyToMono(VisitorsInfo.class);

        VisitorsInfo response = visitorMono.block();
        response.setLastUpdatedBy(LocalDateTime.now());
        System.out.println("Response from ipinfo: "+ response);
        return saveVisitors(response);
    }
}
