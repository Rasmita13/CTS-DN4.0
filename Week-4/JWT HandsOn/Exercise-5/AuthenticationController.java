package com.example.authdemo.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
@RestController
public class AuthenticationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        logger.info("Start of authenticate method");
        logger.debug("Authorization Header received: {}", authHeader);

        String user = getUser(authHeader);  // Decode and extract user
        logger.debug("Decoded user from Authorization header: {}", user);

        Map<String, String> map = new HashMap<>();
        map.put("token", ""); // Empty token for now

        logger.info("End of authenticate method");
        return map;
    }

    private String getUser(String authHeader) {
        logger.debug("Entering getUser method");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            logger.warn("Authorization header is missing or does not start with Basic");
            return "";
        }
        String encodedCredentials = authHeader.substring(6);
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes); // "user:pwd"
        logger.debug("Decoded string from Base64: {}", decodedString);
        String username = decodedString.split(":", 2)[0];
        logger.debug("Extracted username: {}", username);
        return username;
    }
}
