package com.taskmanager.taskmanager.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.taskmanager.taskmanager.entity.Users;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;

import static com.taskmanager.taskmanager.security.SecurityConstants.EXPIRATION_TIME;
import static com.taskmanager.taskmanager.security.SecurityConstants.SECRET;


@Component
public class JwtTokenProvider {
    private static JwtTokenProvider provide;
    public static JwtTokenProvider getInstance(){
        if(provide==null){
            provide = new JwtTokenProvider();
        }
        return provide;
    }

    public String generateToken(Authentication authentication){
        UserDetails user = (UserDetails)authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());

        Date expiryDate = new Date(now.getTime()+EXPIRATION_TIME);


        Map<String,Object> claims = new HashMap<>();
        claims.put("username", user.getUsername());
        claims.put("role", user.getAuthorities());

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        }

    //Validate the token
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex){
            System.out.println("Invalid JWT Signature");
        }catch (MalformedJwtException ex){
            System.out.println("Invalid JWT Token");
        }catch (ExpiredJwtException ex){
            System.out.println("Expired JWT token");
        }catch (UnsupportedJwtException ex){
            System.out.println("Unsupported JWT token");
        }catch (IllegalArgumentException ex){
            System.out.println("JWT claims string is empty");
        }
        return false;
    }


    //Get user Id from token

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        String username = (String) claims.get("username");

        return username;
    }
}