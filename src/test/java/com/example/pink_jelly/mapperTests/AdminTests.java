package com.example.pink_jelly.mapperTests;

import com.example.pink_jelly.member.vo.MemberVO;
import com.example.pink_jelly.admin.AdminSearchDTO;
import com.example.pink_jelly.member.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class AdminTests {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void searchMemberTest() {
        AdminSearchDTO adminSearchDTO = AdminSearchDTO.builder()
                .types(new String[] {"memberId"})
                .keyword("korea")
                .build();
        List<MemberVO> memberVOList = memberMapper.searchAll(adminSearchDTO);
        memberVOList.forEach(log::info);
    }
}
