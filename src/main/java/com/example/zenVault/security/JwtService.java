package com.example.zenVault.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtService {
    private String secretKey = "mysecratekeymysecratekeymysecratekey";
    Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
    private Long expiration = 1000*60*60L;

    public String generateToken(Long userId) {
        String token = Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
        return token;
    }

}
