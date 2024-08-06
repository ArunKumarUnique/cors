package com.example.cors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

@Controller
public class CorsController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Welcome to Cors Testing Application");
    }

    @GetMapping("/downstream")
    public String downstreamAPI() {
        return restTemplate.getForEntity("http://localhost:80/access", String.class).getBody();
    }

    @GetMapping(value = "/error")
    public ResponseEntity<String> error() {
        return ResponseEntity.ok("Something went wrong");
    }

    @GetMapping(value = "/login/oauth2/code/linkedin")
    public ResponseEntity<String> linkedInAuth(Principal principal) {
        return ResponseEntity.ok(principal.toString());
    }

    // return html page
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
}
