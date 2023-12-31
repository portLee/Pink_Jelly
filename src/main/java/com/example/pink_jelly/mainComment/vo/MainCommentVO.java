package com.example.pink_jelly.mainComment.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MainCommentVO { // 메인 게시판 댓글

    private Long comNo;  // 메인 댓글 고유번호
    private Long mbNo; // 메인 게시판 고유번호
    private String memberId; // 회원 아이디
    private String nickName; // 회원 닉네임
    private String comment; // 댓글 내용
    private Long parentNo; // 대댓글이 없으면 = comNo, 대댓글이 있으면 대댓글 고유 번호가 된다
    private LocalDateTime addDate; // 댓글 작성 시간
    private Long mno; //회원 고유넘버
    private String profileImg; //프로필 이미지
}
