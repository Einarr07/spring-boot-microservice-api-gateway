package com.einarr07.spring_boot_microservice_3_api_gateway.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

public class SecurityUtils {

    public static final String ROLE_PREFIX = "ROLE_";

    public static final String AUTH_HEADER = "authorization";
    public static final String AUTH_TOKEN_TIPE = "Bearer";
    public static final String AUTH_TOKE_PREFIX = AUTH_TOKEN_TIPE + " ";

    public static SimpleGrantedAuthority convertToAuthority(String role){
        String formattedRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX + role;
        return new SimpleGrantedAuthority(formattedRole);
    }

    public static String extracAuthTokenFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader((AUTH_HEADER));

        if (StringUtils.hasLength(bearerToken) && bearerToken.startsWith(AUTH_TOKE_PREFIX)){
            return bearerToken.substring(7);
        }

        return null;
    }
}
