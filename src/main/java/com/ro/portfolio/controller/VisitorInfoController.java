package com.ro.portfolio.controller;

import com.ro.portfolio.entity.VisitorsInfo;
import com.ro.portfolio.service.VisitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/visitor")
public class VisitorInfoController {

    @Autowired
    VisitorService visitorService;

    public final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/fetch")
    public ResponseEntity<VisitorsInfo> fetchAndSaveVisitorInfo (){
        VisitorsInfo visitorsInfo = visitorService.fetchAndSaveProject();
        log.info("Visitor fetch '/visitor/fetch' API succeed");
        return ResponseEntity.ok(visitorsInfo);
    }
}
