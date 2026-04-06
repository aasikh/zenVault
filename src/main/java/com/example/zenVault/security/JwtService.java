package com.example.zenVault.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
@Service
public class JwtService {
    private final String secretKey = "mysecratekeymysecratekeymysecratekey";
    private final Long expiration = 1000*60*60L;

    private Key getSigningKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
    public String generateToken(Long userId) {
        String token = Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey())
                .compact();
        return token;
    }
    public boolean validateToken(String token) {
    try{
    Jwts.parserBuilder()
            .setSigningKey(getSigningKey())
            .build()
            .parseClaimsJws(token);
           return true;
    }catch(Exception e){
        System.out.println("token validation failed" + e.getMessage());
      return false;
   }

    }
    public Claims extractAllClaims(String token){

        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public Long extractUserIDFromToken(String token){
        Claims claim = extractAllClaims(token);
       return Long.parseLong(claim.getSubject());
    }

}
