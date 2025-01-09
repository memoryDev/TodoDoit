package dev.memory.tododoit.service;

import dev.memory.tododoit.dto.UserSignupRequest;
import dev.memory.tododoit.entity.User;
import dev.memory.tododoit.exception.CustomException;
import dev.memory.tododoit.exception.ErrorCode;
import dev.memory.tododoit.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void registerUser(UserSignupRequest request) {

        // 1. 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        log.debug("password = {}", request.getPassword());
        log.debug("encodedPassword = {}", encodedPassword);

        // 2. DTO to Entity
        User userEntity = request.toEntity(encodedPassword);

        // 3. 계정 중복검사
        if (userRepository.existsNotDeletedByAccountId(userEntity.getAccountId())) {
            ErrorCode errorCode = ErrorCode.ACCOUNT_ALREADY_EXISTS;
            log.debug("AuthService.registerUser.existsNotDeletedByAccountId = [{}] - {}", userEntity.getAccountId(), errorCode);
            throw new CustomException(errorCode);
        }

        // 4. 이메일 중복검사
        if (userRepository.existsNotDeletedByEmail(userEntity.getEmail())) {
            ErrorCode errorCode = ErrorCode.EMAIL_ALREADY_EXISTS;
            log.debug("AuthService.registerUser.existsNotDeletedByEmail = [{}] - {}", userEntity.getEmail(), errorCode);
            throw new CustomException(errorCode);
        }

        // 5. db 저장
        userRepository.save(userEntity);

    }
}
