package dev.memory.tododoit.globalException;

import dev.memory.tododoit.exception.CustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GlobalExceptionTest {

//    @Test
    @DisplayName("글로벌 오류 테스트")
    void globalTests () {
        Assertions.assertThrows(CustomException.class, () -> {
//           throw new CustomException(ErrorCode.NOT_FUN);
        });
    }
}
