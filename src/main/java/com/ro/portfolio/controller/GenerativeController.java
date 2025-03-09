package com.ro.portfolio.controller;

import com.ro.portfolio.service.GenerativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/generate")
public class GenerativeController {

    @Autowired
    private GenerativeService generativeService;

    @ModelAttribute("chatHistory")
    public List<String> getChatHistory() {
        return new ArrayList<>();
    }

    @PostMapping("/ask")
    public Mono<Map> askGemini(@RequestBody Map<String, String> body) {
        String question = body.get("question");

        if (question == null || question.trim().isEmpty()) {
            return Mono.just(Map.of("error", "Question cannot be empty"));
        }

        return generativeService.askGemini(question);
    }
}
