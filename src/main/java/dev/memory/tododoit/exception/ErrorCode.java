package dev.memory.tododoit.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    /**
     * testCode 추후 추가 예정
     */
    NOT_FUN(HttpStatus.NOT_FOUND, "T-001", "테스트코드입니다 추후삭제예정.");

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String message;

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }

}
