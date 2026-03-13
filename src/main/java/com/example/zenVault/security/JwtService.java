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
    public boolean validateToken(String token) {
    try{
    Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token);
           return true;
    }catch(Exception e){
      return false;
   }

    }
    public Claims extractAllClaims(String token){

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public Long extractUserIDFromToken(String token){
        Claims claim = extractAllClaims(token);
       return Long.parseLong(claim.getSubject());
    }

}
