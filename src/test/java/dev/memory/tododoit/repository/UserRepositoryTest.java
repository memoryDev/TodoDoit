package dev.memory.tododoit.repository;

import dev.memory.tododoit.entity.Deleted;
import dev.memory.tododoit.entity.Provider;
import dev.memory.tododoit.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실제 DB 사용
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

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

}