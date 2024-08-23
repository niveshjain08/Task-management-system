package com.example.TaskManagementSystem.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class TokenUtils {

    // Securely generated key that is consistent across the application
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Generate key once and use it

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 hours expiry
                .signWith(key) // Use the secure key
                .compact();
    }

    public static Key getKey() {
        return key;
    }
}
