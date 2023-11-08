package ru.garrowd.newsservice.utils;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import ru.garrowd.newsservice.utils.enums.JwtClaims;

public class Token {
    public static String get(JwtAuthenticationToken token, JwtClaims attribute){
        return (String) token.getTokenAttributes().get(attribute.getValue());
    }
}
