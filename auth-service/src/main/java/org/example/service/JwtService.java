package org.example.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.example.config.CustomUserDetails;
import org.example.model.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;

@Component
public class JwtService {
    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    public void validateToken(final String token){
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }

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
