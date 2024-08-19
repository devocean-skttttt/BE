package com.filterrecipe.auth.config;

import com.filterrecipe.common.exception.CustomException;
import com.filterrecipe.common.exception.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Objects;
import org.springframework.http.HttpHeaders;

public class AuthorizationExtractor {

    private static final String BEARER_TYPE = "Bearer ";

    public static String extract(final HttpServletRequest request) {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (Objects.isNull(authorizationHeader)) {
            throw new CustomException(ErrorCode.TOKEN_EXPIRED);
        }

        validateAuthorizationFormat(authorizationHeader);
        return authorizationHeader.substring(BEARER_TYPE.length()).trim();
    }

    private static void validateAuthorizationFormat(final String authorizationHeader) {
        if (!authorizationHeader.toLowerCase().startsWith(BEARER_TYPE.toLowerCase())) {
            throw new CustomException(ErrorCode.TOKEN_INVALID);
        }
    }
}