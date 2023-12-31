package com.example.pink_jelly.member.service;

import com.example.pink_jelly.member.dto.MemberDTO;

public interface MemberService {
    void registerMember(MemberDTO memberDTO); // 회원가입

    void removeMember(Long mno); // 회원탈퇴

    void modifyMemberInfo(MemberDTO memberDTO);  // 회원수정(이메일, 이름, 전화번호, 닉네임, 소개글)

    void modifyPasswd(MemberDTO memberDTO); // 비밀번호변경

    void modifyMyCat(MemberDTO memberDTO); // 고양이 정보 수정

    MemberDTO getMember(Long mno); // 회원정보 가져오기

    MemberDTO login(String memberId, String passwd); // 로그인 처리

    MemberDTO findById(String memberId); // 아이디로 회원 정보 조회

    boolean checkIdDuplicate(String memberId); // 아이디 중복 체크
    
    String getFileName(Long mno); // 프로필 사진 가져오기

    void updateIntroduce(MemberDTO memberDTO); // 회원 소개글 수정

}
