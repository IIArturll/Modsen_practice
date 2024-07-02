package com.example.productservice.security.jwt;

import com.example.productservice.security.MyUserDetails;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {
    @Value("${jwt.access.secret}")
    private String jwtAccessSecret;

    @Value("${jwt.access.expirationMs}")
    private int jwtAccessExpirationMs;

    public String generateAccessToken(MyUserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtAccessExpirationMs))
                .claim("login", userDetails.getLogin())
                .claim("role", userDetails.getRole())
                .signWith(SignatureAlgorithm.HS512, jwtAccessSecret)
                .compact();
    }


    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtAccessSecret)
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
//            log.error("Token expired", expEx);
        } catch (UnsupportedJwtException unsEx) {
//            log.error("Unsupported jwt", unsEx);
        } catch (MalformedJwtException mjEx) {
//            log.error("Malformed jwt", mjEx);
        } catch (SignatureException sEx) {
//            log.error("Invalid signature", sEx);
        } catch (Exception e) {
//            log.error("invalid token", e);
        }
        return false;
    }

    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    public String getUserRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    public String getUserLogin(String token) {
        return getClaims(token).get("login", String.class);
    }

    private Claims getClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtAccessSecret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
}
