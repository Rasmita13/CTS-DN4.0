package com.example.authdemo.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        logger.info("Start of authenticate method");
        logger.debug("Authorization Header received: {}", authHeader);

        String user = getUser(authHeader);
        logger.debug("Decoded user from Authorization header: {}", user);

        String token = generateJwt(user);
        logger.debug("Generated JWT token: {}", token);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        logger.info("End of authenticate method");
        return map;
    }

    private String getUser(String authHeader) {
        logger.debug("Entering getUser method");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            logger.warn("Authorization header is missing or invalid");
            return "";
        }

        String encodedCredentials = authHeader.substring(6);
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes);
        logger.debug("Decoded string from Base64: {}", decodedString);

        String username = decodedString.split(":", 2)[0];
        logger.debug("Extracted username: {}", username);

        return username;
    }

    private String generateJwt(String user) {
        logger.debug("Entering generateJwt method with user: {}", user);

        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");

        String token = builder.compact();
        logger.debug("JWT token generated successfully");
        return token;
    }
}
