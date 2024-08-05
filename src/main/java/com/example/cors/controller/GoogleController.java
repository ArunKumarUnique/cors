package com.example.cors.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/google")
public class GoogleController {

    @GetMapping(value = "/login")
    public Object googleLogin(@RequestBody Principal principal, HttpServletRequest request) {
        return "Google Login successful. User:" + principal.toString();
    }

    @GetMapping(value = "/user")
    public Object googleUser(@RequestBody Principal principal, HttpServletRequest request) {
        return "Google Logged in user: " + principal.toString();
    }
}
