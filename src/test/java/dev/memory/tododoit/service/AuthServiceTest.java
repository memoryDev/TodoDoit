package dev.memory.tododoit.service;

import dev.memory.tododoit.dto.UserSignupRequest;
import dev.memory.tododoit.entity.User;
import dev.memory.tododoit.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("회원가입 요청 정보")
    void testRegisteruser_success() {
        UserSignupRequest request = new UserSignupRequest("account01", "password01", "account1@memory.dev");

        Mockito.when(passwordEncoder.encode(request.getPassword())).thenReturn("encodedPassword");
        Mockito.when(userRepository.existsNotDeletedByAccountId("account01")).thenReturn(false);
        Mockito.when(userRepository.existsNotDeletedByEmail("account1@memory.dev")).thenReturn(false);

        authService.registerUser(request);

        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(User.class));


    }



}