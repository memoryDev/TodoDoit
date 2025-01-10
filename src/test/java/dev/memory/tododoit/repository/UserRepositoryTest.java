package dev.memory.tododoit.repository;

import dev.memory.tododoit.config.QueryDslConfig;
import dev.memory.tododoit.entity.Deleted;
import dev.memory.tododoit.entity.Provider;
import dev.memory.tododoit.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@DataJpaTest
@Import(QueryDslConfig.class)
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

        User user3 = new User("account03", "account03@memory.dev", "password3",
                Provider.KAKAO, "socialId03", Deleted.N);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }

    @Test
    @DisplayName("계정 존재여부 테스트")
    void accoutTest1() {

        Boolean finedUser1 = userRepository.existsNotDeletedByAccountId("account01");
        Boolean finedUser2 = userRepository.existsNotDeletedByAccountId("account02");
        Boolean finedUser3 = userRepository.existsNotDeletedByAccountId("account03");
        Boolean finedUser4 = userRepository.existsNotDeletedByAccountId("account04");

        Assertions.assertTrue(finedUser1);
        Assertions.assertTrue(finedUser2);
        Assertions.assertTrue(finedUser3);

        Assertions.assertFalse(finedUser4);

    }

    @Test
    @DisplayName("이메일 존재여부 테스트")
    void accoutTest2() {

        Boolean finedUser1 = userRepository.existsNotDeletedByEmail("account01@memory.dev");
        Boolean finedUser2 = userRepository.existsNotDeletedByEmail("account02@memory.dev");
        Boolean finedUser3 = userRepository.existsNotDeletedByEmail("account03@memory.dev");
        Boolean finedUser4 = userRepository.existsNotDeletedByEmail("account045645646@asdasd.sss");

        Assertions.assertTrue(finedUser1);
        Assertions.assertTrue(finedUser2);
        Assertions.assertTrue(finedUser3);

        Assertions.assertFalse(finedUser4);

    }

}