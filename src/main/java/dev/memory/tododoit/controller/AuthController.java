package dev.memory.tododoit.controller;

import dev.memory.tododoit.dto.UserSignupRequest;
import dev.memory.tododoit.entity.User;
import dev.memory.tododoit.exception.SuccessResponse;
import dev.memory.tododoit.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    /**
     * 일반 회원가입
     * @param request: 회원 입력 값
     * @return
     */
    @PostMapping("/signup")
    public SuccessResponse<User> registerUser(@Valid @RequestBody UserSignupRequest request) {
        log.debug("AuthController.registerUser = {}", request);
        authService.registerUser(request);

        return SuccessResponse.of("회원가입 성공하셨습니다.", null);
    }
}
