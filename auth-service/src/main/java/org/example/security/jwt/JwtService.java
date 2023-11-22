package org.example.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.example.config.CustomUserDetails;
import org.example.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;

@Component
public class JwtService {
    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);
    public String generateToken(Authentication authentication){
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        Map<String, Object> roleClaims = createRoleClaimsFromAuthorities(user.getAuthorities());
        return createToken(roleClaims, user.getUsername());
    }

    private Map<String, Object> createRoleClaimsFromAuthorities(Collection<? extends GrantedAuthority> authorities){
        Map<String, Object> roleClaims = new HashMap<>();
        List<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        roleClaims.put("role", roles);
        return roleClaims;
    }

    private String createToken(Map<String, Object> claims, String username){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) //30min
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private static Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateTokenForUser(String authToken, UserDetails userDetails) {
        final String username = extractUsername(authToken);
        return username.equals(userDetails.getUsername()) && validateToken(authToken);
    }

    public boolean validateToken(String authToken){
        try {
            Jwts.parserBuilder().setSigningKey(getSignKey()).build().parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    public static boolean hasAnyRole(String token, Role... roles){
        List<String> userRoles = getRolesFromJwtToken(token);
        if(userRoles == null)
            return false;
        for(Role roleToCheck:roles){
            if(userRoles.contains(roleToCheck.name()))
                return true;
        }
        return false;
    }

    private static List<String> getRolesFromJwtToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return null;
    }
}
