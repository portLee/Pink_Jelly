package com.example.pink_jelly.mainBoard.vo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MainBoardVO { // 메인 게시판

    private Long mbNo; // 메인게시판 고유넘버
    private String memberId; // 회원 아이디
    private String nickName; // 회원 닉네임
    private String profileImg; // 회원 프로필 이미지
    private String title; // 게시물 제목
    private String content; // 게시물 내용
    private String mainImg; // 게시물 이미지
    private LocalDateTime addDate; // 게시물 등록날짜
    private String myCat; // 본인 고양이인지 확인
    private String variety; // 내 고양이 품종
    private Long commentCnt; // 게시물 댓글수
    private Long like; // 게시물 좋아요수
    private Long hit; // 게시물 조회수
    private Long mno; //회원 고유넘버
}
