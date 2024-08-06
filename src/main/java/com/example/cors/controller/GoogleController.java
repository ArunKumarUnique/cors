package com.example.cors.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping(value = "/google")
public class GoogleController {

    @GetMapping(value = "/login")
    public Object googleLogin(@RequestBody Principal principal, HttpServletRequest request) {
        return "Google Login successful. User:" + principal.toString();
    }

    @GetMapping("/user")
    public Model googleUser(Principal principal, Model model) {
        if (principal instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) principal;
            OAuth2User user = authToken.getPrincipal();
            Map<String, Object> attributes = user.getAttributes();

            // Add user attributes to the model to display in the view
            model.addAttribute("name", attributes.get("name"));
            model.addAttribute("email", attributes.get("email"));
            model.addAttribute("picture", attributes.get("picture"));
        }
        return model;
//        return "user"; // This should match the name of your user HTML template
    }
}
