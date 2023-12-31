package com.example.pink_jelly.crbComment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CRBCommentDTO {
    private Long comNo; // 댓글 고유번호
    private Long crbNo; // 입양후기 고유번호
    private String memberId; // 회원 아이디
    private String nickName; // 닉네임
    private String comment; // 댓글 내용
    private Long parentNo; // 대댓글 고유 번호
    private LocalDateTime addDate; // 등록 날짜
    private Long mno; //회원 고유넘버
    private String profileImg; //프로필 이미지
    private String dateString; // 프로필 이미지 저장 날짜

}
