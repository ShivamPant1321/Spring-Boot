package com.codingshuttle.youtube.hospitalManagement.security;

import com.codingshuttle.youtube.hospitalManagement.entity.User;
import com.codingshuttle.youtube.hospitalManagement.entity.type.AuthProviderType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@Component
@Slf4j
public class AuthUtil {

    @Value("${jwt.secretKey}")
    private String jwtSecretKey;

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken(User user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("userId", user.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*10))
                .signWith(getSecretKey())
                .compact();
    }

    public String getUsernameFromToker(String token) {
        Claims claim = Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload();
        return claim.getSubject();

    }
    public AuthProviderType getProviderTypeFromRegistrationId(String registrationId) {
        return switch (registrationId.toLowerCase()){
            case "google" -> AuthProviderType.GOOGLE;
            case "faceboook" -> AuthProviderType.FACEBOOK;
            case "github" -> AuthProviderType.GITHUB;
            case "twitter" -> AuthProviderType.TWITTER;
            default -> throw new IllegalArgumentException("Unsupported OAuth2 provider: "+registrationId);
        };
    }

    public String determineProviderIdFromOAuth2User(OAuth2User oAuth2User, String registrationId) {
        String providerId = switch(registrationId.toLowerCase()){
            case "google" -> oAuth2User.getAttribute("sub");
            case "github" -> oAuth2User.getAttribute("id").toString();
            default -> {
                log.error("Unsupported OAuth2 provider: "+registrationId);
                throw new IllegalArgumentException("Unsupported OAuth2 provider: "+registrationId);
            }
        };

        if (providerId == null || providerId.isBlank()){
            log.error("Unable to determine provider id for provider: {}"+registrationId);
            throw new IllegalArgumentException("Unable to determine provider id for OAuth2 login");
        }
        return providerId;
    }

    public String determineUsernameFromOAuth2User(OAuth2User oAuth2User, String registrationId, String providerId) {
        String email = oAuth2User.getAttribute("email");
        if(email != null || !email.isBlank()){
            return email;
        }
        return switch (registrationId.toLowerCase()){
            case "google" -> oAuth2User.getAttribute("sub");
            case "github" -> oAuth2User.getAttribute("login");
            default -> providerId;
        };
    }
}
