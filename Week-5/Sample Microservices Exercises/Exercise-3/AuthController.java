package com.example.jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if ("user".equals(username) && "password".equals(password)) {
            String token = jwtTokenProvider.createToken(username);
            return Map.of("token", token);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}

