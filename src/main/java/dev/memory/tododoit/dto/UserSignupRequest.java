package dev.memory.tododoit.dto;

import dev.memory.tododoit.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserSignupRequest {

    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(min = 6, message = "아이디를 6자 이상 입력해주세요.")
    @Pattern(regexp = "^[A-Za-z0-9_-]+$",
             message = "아이디는 영어 및 숫자와 '-', '_'만 입력 가능합니다.")
    private String accountId;           // 계정 아이디

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 6, max = 20, message = "비밀번호를 8자 ~ 20자이하로 입력해주세요.")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함하여 입력해주세요.")
    private String password;            // 계정 비밀번호

    @NotBlank(message = "이메일을 입력해주세요.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
             message = "이메일 형식으로 입력해주세요.")
    private String email;               // 계정 비밀번호


    // DTO -> Entity 변환 메서드
    public User toEntity(String encodedPassword) {
        return new User(this.accountId, this.email, encodedPassword);
    }
}
