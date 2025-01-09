package dev.memory.tododoit.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
public class ErrorResponse {
    private final LocalDateTime timestamp;  // 오류발생 시간
    private final int statusCode;           // 오류 상태코드
    private final String errorCode;         // 오류코드
    private final String message;           // 반환 메세지
    private final Map<String, String> details; // 추가 정보(선택사항)

    public static ErrorResponse of(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(errorCode.getHttpStatus().value())
                .errorCode(errorCode.getErrorCode())
                .message(errorCode.getMessage())
                .build();
    }
}
