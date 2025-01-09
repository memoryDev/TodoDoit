package dev.memory.tododoit.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    /**
     * 유저
     */
    ACCOUNT_ALREADY_EXISTS(HttpStatus.CONFLICT, "A-001", "계정이 이미 존재합니다"),
    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "A-002", "이메일이 이미 존재합니다");

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String message;

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }

}
