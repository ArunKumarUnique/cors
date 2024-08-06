package com.example.cors.controller;

import com.example.cors.service.LinkedInService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/linkedin")
public class LinkedInController {

    @Autowired
    private LinkedInService linkedInService;

    @GetMapping(value = "/login")
    public Object linkedInLogin(@RequestBody Principal principal, HttpServletRequest request) {
        return "LinkedIn Login successful. User:" + principal.toString();
    }

    @GetMapping(value = "/user")
    public Object linkedInUser(@RequestBody Principal principal, HttpServletRequest request) {
        return "LinkedIn Logged in user: " + principal.toString();
    }

    @PostMapping(value = "/post")
    public ResponseEntity<?> linkedInPost(@RequestBody Principal principal, HttpServletRequest request) {
        return linkedInService.linkedInPost(principal, request);
    }
}
