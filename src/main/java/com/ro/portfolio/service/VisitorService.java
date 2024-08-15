package com.ro.portfolio.service;

import com.ro.portfolio.entity.VisitorsInfo;
import com.ro.portfolio.repo.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * Service class to save the visitor info
 */
@Service
public class VisitorService {
    @Autowired
    VisitorRepository visitorRepository;

    // Initialize webclient to make web request
    private final WebClient webClient;

    //Constructor to build the webclient instance
    public VisitorService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://ipinfo.io").build();
    }

    // service method to save the visitor info
    private VisitorsInfo saveVisitors (VisitorsInfo visitorsInfo){
        return visitorRepository.save(visitorsInfo);
    }

    /**
     * Used to set the updated by value and save to db
     * @param visitorsInfo
     * @return
     */
    public VisitorsInfo fetchAndSaveProject(VisitorsInfo visitorsInfo) {

        visitorsInfo.setLastUpdatedBy(LocalDateTime.now());
        System.out.println("Response from ipinfo: "+ visitorsInfo);
        return saveVisitors(visitorsInfo);
    }
}
