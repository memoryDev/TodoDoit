package dev.memory.tododoit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "user")
@Getter
public class User extends BaseEntity {

    public User() {
    }

    public User(String accountId, String email, String password, Provider socialProvider, String socialId, Deleted isDeleted) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.socialProvider = socialProvider;
        this.socialId = socialId;
        this.isDeleted = isDeleted;
    }

    public User(String accountId, String email, String password) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.isDeleted = Deleted.N;
    }

    @Id
    @Comment(value = "사용자 고유 ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Comment(value = "사용자 계정 ID")
    private String accountId;

    @Comment(value="사용자 이메일")
    private String email;

    @Comment(value = "비밀번호")
    private String password;

    @Enumerated(EnumType.STRING)
    @Comment(value = "소셜 로그인 제공자")
    private Provider socialProvider;

    @Comment(value = "소셜 로그인ID")
    private String socialId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Comment(value = "삭제여부")
    private Deleted isDeleted;

}
