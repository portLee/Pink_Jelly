package com.example.pink_jelly.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO implements UserDetails, OAuth2User {
    private Long mno; // 회원 고유 넘버

    @NotEmpty(message = "아이디를 입력해주세요")
    private String memberId; // 회원 아이디

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,}", message = "비밀번호는 8자이상 영문 대 소문자, 숫자, 특수문자를 사용하세요")
    private String passwd; // 회원 비밀번호

    @NotBlank(message = "이메일을 입력해주세요")
    @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다")
    private String email; // 회원 이메일

    @NotBlank(message = "이름을 입력해주세요")
    private String memberName; // 회원이름

    @NotBlank(message = "전화번호를 입력해주세요")
    private String phone; // 회원 전화번호

    @NotBlank
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,15}$", message = "닉네임은 특수문자를 제외한 2~15자리여야 합니다")
    private String nickName; // 회원 닉네임

    private boolean hasCat; // 고양이 여부

    private String catAge; // 고양이 나이 (개월/년)
    private String catSex; // 고양이 성별
    private String variety; // 고양이 품종
    private String profileImg; // 프로필이미지 (고양이사진)
    private int gmingCnt; // 그루밍 수
    private int gmerCnt; // 그루머 수
    private String introduce; // 소개글
    private LocalDate addDate; //등록 날짜

    private boolean del; // 회원 탈퇴 여부
    private boolean social; // 소셜 로그인
    private Map<String, Object> props; // 소셜 로그인 정보

    private String dateString; // 이미지 저장 날짜
    private boolean flag; // 친구 여부
    private boolean ban; // 차단 여부

    @Override
    public Map<String, Object> getAttributes() {
        return this.getProps();
    }
    @Override
    public String getName() {
        return this.memberId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();
    }

    @Override
    public String getPassword() {
        return this.passwd;
    }

    @Override
    public String getUsername() {
        return this.memberId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
