package com.projectFile.AutoStack.Security;

import com.projectFile.AutoStack.Entity.User;
import com.projectFile.AutoStack.Repository.UserRepo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class AuthUtil {
    @Value("${jwt.secret-key}")
    private  String SECRET_KEY;


    private SecretKey GetSign_Key() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String RefreshToken( User user) {
        String token = Jwts.builder()
                .subject(user.getEmail())
                .claim("id", String.valueOf(user.getId()))
                .claim("name", user.getName())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + (1000 * 60 * 10)))
                .signWith(GetSign_Key())
                .compact();
        return token;


    }
    public JwtUserPrincipal VerifyAccessToken(String accessToken){
        Claims claims= Jwts.parser()
                .verifyWith(GetSign_Key())
                .build()
                .parseSignedClaims(accessToken)
                .getPayload();
        Long userId=  Long.parseLong(claims.get("id",String.class));
        String userEmail=claims.getSubject();
        return new JwtUserPrincipal(userId,userEmail,new ArrayList<>());
    }
}
