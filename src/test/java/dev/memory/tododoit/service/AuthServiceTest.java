package dev.memory.tododoit.service;

import dev.memory.tododoit.dto.UserSignupRequest;
import dev.memory.tododoit.entity.Deleted;
import dev.memory.tododoit.entity.Provider;
import dev.memory.tododoit.entity.User;
import dev.memory.tododoit.repository.UserCustomRepository;
import dev.memory.tododoit.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class AuthServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;
    @Autowired
    private UserCustomRepository userCustomRepository;

    /**
     * 테스트 실행전 더미데이터 생성
     */
    @BeforeEach
    void setUp() {
        User user1 = new User("account01", "account01@memory.dev", "password1",
                Provider.KAKAO, "socialId01", Deleted.N);

        User user2 = new User("account02", "account02@memory.dev", "password2",
                Provider.KAKAO, "socialId02", Deleted.N);

        User user3 = new User("account03", "account02@memory.dev", "password3",
                Provider.KAKAO, "socialId03", Deleted.N);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }

    @Test
    void registerUser () {


//        UserSignupRequest request = new UserSignupRequest("account04", "account04@memory.dev", "account04");

//        authService.registerUser(request);

    }

}