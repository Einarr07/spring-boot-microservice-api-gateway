package com.einarr07.spring_boot_microservice_3_api_gateway.security.jwt;

import com.einarr07.spring_boot_microservice_3_api_gateway.model.User;
import com.einarr07.spring_boot_microservice_3_api_gateway.security.UserPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface JwtProvider {
    String generateToken(UserPrincipal auth);

    String generateToken(User user);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
