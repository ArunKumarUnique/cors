package com.example.cors.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@Slf4j
public class LinkedInService {

    private String clientId = "862no3rx3utz5y";
    private String secret = "AfDW6s98ROZxElt6";

    public ResponseEntity<?> linkedInPost(Principal principal, HttpServletRequest request) {
        return ResponseEntity.ok().body(principal.getName());
    }
}
