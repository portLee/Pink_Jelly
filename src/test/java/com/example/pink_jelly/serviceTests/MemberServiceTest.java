package com.example.pink_jelly.serviceTests;

import com.example.pink_jelly.member.dto.MemberDTO;
import com.example.pink_jelly.member.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Test
    public void registerTest(){
        MemberDTO memberDTO = MemberDTO.builder()
                .memberId("TestId2")
                .passwd("1234")
                .email("test@naver.com")
                .memberName("TestName2")
                .phone("01012341234")
                .nickName("TestNick2")
                .hasCat(true)
                .catAge("3")
                .catSex("여아")
                .variety("샴")
                .profileImg("uuid+fileImg2")
                .build();
        memberService.registerMember(memberDTO);
    }

    @Test
    public void remove(){
        memberService.removeMember(3L);
    }

    @Test
    public void modifyMember(){
        MemberDTO memberDTO = MemberDTO.builder()
                .email("modifyEmail")
                .memberName("updateName")
                .phone("010-2222-2222")
                .nickName("modifyNickName")
                .mno(1L)
                .build();
        memberService.modifyMemberInfo(memberDTO);
    }

    @Test
    public void modifyMyCatTest() {
        MemberDTO memberDTO = MemberDTO.builder()
                .hasCat(true)
                .catAge("10년")
                .catSex("여아")
                .variety("노르웨이숲")
                .profileImg("updateImg1")
                .mno(3L)
                .build();
        memberService.modifyMyCat(memberDTO);
    }

    @Test
    public void login(){
        log.info(memberService.login("test3", "3333"));
    }

    @Test
    public void getFileNameTest() {
        String fileName = memberService.getFileName(27L);
        log.info(fileName);
    }
}
