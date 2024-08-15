package com.ro.portfolio.controller;

import com.ro.portfolio.entity.VisitorsInfo;
import com.ro.portfolio.model.TokenModel;
import com.ro.portfolio.service.VisitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Visitor Controller to Save the visitor info
 */
@RestController
@RequestMapping("/api/visitor")
public class VisitorInfoController {

    @Autowired
    VisitorService visitorService;

    @Value("${VISITOR_URL}")
    private String visitorUrl;
    @Value("${VISITOR_KEY}")
    private String visitorKey;
    @Value("${spring.app.base.url}")
    private String baseURL;
    @Value("${fetch.visitor.ip.url}")
    private String fetchIpURL;
    
    // Initializing the Log instance
    public final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * API to save the and Every visitors' information.
     * @param visitorsInfo  visitors information
     * @return saved Entity
     */
    @PostMapping("/save")
    public ResponseEntity<VisitorsInfo> fetchAndSaveVisitorInfo (@RequestBody VisitorsInfo visitorsInfo){
        VisitorsInfo visitorsInfo1 = visitorService.fetchAndSaveProject(visitorsInfo);
        log.info("Visitor fetch '/visitor/save' API succeed " + visitorsInfo1);
        return ResponseEntity.ok(visitorsInfo1);
    }

    /**
     * Endpoint to share the URL credentials to WebApp
     * @return URL's
     */
    @GetMapping("/config")
    public ResponseEntity<TokenModel> getVisitorBackBone(){
        log.info("Visitor Config send successfully!");
        return ResponseEntity.ok(new TokenModel(this.baseURL,this.visitorUrl,this.visitorKey, this.fetchIpURL));
    }
}
