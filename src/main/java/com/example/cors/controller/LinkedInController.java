package com.example.cors.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "")
public class LinkedInController {

    @GetMapping(value = "/login")
    public Object linkedInLogin(@RequestBody Principal principal, HttpServletRequest request) {
        return "LinkedIn Login successful. User:" + principal.toString();
    }

    @GetMapping(value = "/user")
    public Object linkedInUser(@RequestBody Principal principal, HttpServletRequest request) {
        return "LinkedIn Logged in user: " + principal.toString();
    }
}
