package com.example.cors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CorsController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String healthCheck() {
        return "Welcome to Cors Testing Application";
    }

    @GetMapping("/downstream")
    public String downstreamAPI() {
        return restTemplate.getForEntity("http://localhost:80/access", String.class).getBody();
    }
}
