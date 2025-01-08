package dev.memory.tododoit.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private final LocalDateTime timestamp;  // 오류발생 시간
    private final int statusCode;           // 오류 상태코드
    private final String errorCode;         // 오류코드
    private final String message;           // 반환 메세지

    public ErrorResponse(ErrorCode errorCode) {
        this.timestamp = LocalDateTime.now();
        this.statusCode = errorCode.getHttpStatus().value();
        this.errorCode = errorCode.getErrorCode();
        this.message = errorCode.getMessage();
    }

    // ErrorCode를 기반으로 ErrorResponse 생성
    public static ErrorResponse of(ErrorCode errorCode) {
        return new ErrorResponse(errorCode);
    }
}
