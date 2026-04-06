package com.example.zenVault.security;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        System.out.println("your header is " +header);
        if (header != null && header.startsWith("Bearer ")) {

            String token = header.substring(7);
            System.out.println("your token is " +token);
            if (jwtService.validateToken(token)) {

                Long id = jwtService.extractUserIDFromToken(token);
                System.out.println("your id is " +id);
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(id, null, null);

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
    }

}