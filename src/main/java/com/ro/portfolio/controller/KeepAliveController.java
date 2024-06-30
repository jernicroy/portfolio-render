package com.ro.portfolio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API to Pinch the Server to wakeup by prevent it from
 * spin down
 */
@RestController
@RequestMapping("/api/pinch")
public class KeepAliveController {

    @GetMapping("")
    public String pinchToAlive(){
        return "I am Alive, and not tobe spin down";
    }
}
