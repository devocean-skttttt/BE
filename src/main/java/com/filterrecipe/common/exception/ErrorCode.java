package com.filterrecipe.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    SIGN_UP_NULL(HttpStatus.BAD_REQUEST, "1400", "회원가입 중 빈 값이 존재합니다."),
    LOGIN_ID_DUPLICATED(HttpStatus.CONFLICT, "1409", "아이디가 중복됩니다"),
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "1401", "JWT 토큰이 만료되었습니다."),
    TOKEN_INVALID(HttpStatus.BAD_REQUEST, "1400", "토큰 형식이 잘못 되었습니다."),
    LOGIN_FAILED(HttpStatus.NOT_FOUND, "1404", "로그인 또는 패스워드가 일치하지 않습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "1404", "해당 사용자를 찾을 수 없습니다."),
    DELETE_USER_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "1500", "사용자 탈퇴 처리 중 오류가 발생했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}