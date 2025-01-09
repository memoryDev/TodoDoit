package dev.memory.tododoit.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Builder
public class SuccessResponse<T> {

    private final LocalDateTime timestamp;  // 성공 시간
    private final int statusCode;           // 성공 상태코드
    private final String errorCode;         // 성공 코드
    private final String message;           // 성공 메세지
    private final T data; // 추가 정보(선택사항)

    public static <T> SuccessResponse of(String message, T data) {
        return SuccessResponse.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.OK.value())
                .errorCode("SU-001")
                .message(message)
                .data(data)
                .build();
    }

}
