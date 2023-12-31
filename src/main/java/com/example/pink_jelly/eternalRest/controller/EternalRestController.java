package com.example.pink_jelly.eternalRest.controller;

import com.example.pink_jelly.eternalRest.dto.EternalRestBoardDTO;
import com.example.pink_jelly.eternalRest.service.EternalRestBoardService;
import com.example.pink_jelly.member.dto.MemberDTO;
import com.example.pink_jelly.dto.PageRequestDTO;
import com.example.pink_jelly.dto.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;

@Log4j2
@RequiredArgsConstructor
@Controller
@RequestMapping("/eternalRest")
public class EternalRestController {

    private final EternalRestBoardService eternalRestBoardService;
    private final UserDetailsService userDetailsService;

    @GetMapping("") // 장례식 게시판 목록
    public String list(Model model, PageRequestDTO pageRequestDTO){

        PageResponseDTO<EternalRestBoardDTO> restBoardList = eternalRestBoardService.getList(pageRequestDTO);
        model.addAttribute("restBoardList", restBoardList);

        return "eternalRest/list";
    }

    @PostMapping("/write") // 게시판 자동등록
    public String write(EternalRestBoardDTO eternalRestBoardDTO, @AuthenticationPrincipal MemberDTO memberDTO){
        // 로그인유저 정보 입력
        eternalRestBoardDTO.setMemberId(memberDTO.getMemberId());
        eternalRestBoardDTO.setNickName(memberDTO.getNickName());

        eternalRestBoardDTO.setProfileImg(memberDTO.getDateString()+"/"+memberDTO.getProfileImg());
        log.info("----------" + eternalRestBoardDTO.getProfileImg());
        eternalRestBoardDTO.setMno(memberDTO.getMno());
        eternalRestBoardDTO.setTitle("우리의 친구 ["+memberDTO.getNickName()+"]이(가) 무지개 다리를 건넜습니다");
        eternalRestBoardDTO.setContent(memberDTO.getNickName()+"은(는) 당신을 만났기에 가장 행복한 고양이였습니다");
        Long mno = memberDTO.getMno();

        eternalRestBoardService.register(eternalRestBoardDTO); // 글등록 후
        eternalRestBoardService.catInfoDel(mno); // 정보 삭제

        sessionReset(memberDTO);
        return "redirect:/eternalRest";
    }

    @GetMapping("/view") // 게시물 상세뷰
    public void view(Model model ,Long erbNo, Long mno, @AuthenticationPrincipal MemberDTO memberDTO){
        EternalRestBoardDTO eternalRestBoardDTO = null;

        if(memberDTO != null){
            mno = memberDTO.getMno();
            eternalRestBoardDTO = eternalRestBoardService.getBoard(erbNo, mno);
            eternalRestBoardDTO.setFlag(eternalRestBoardService.isRestSad(mno, erbNo));
            log.info("컨트롤러 : flag : " +eternalRestBoardService.isRestSad(mno, erbNo));
            log.info("컨트롤러 dto : " + eternalRestBoardDTO.isFlag());
            model.addAttribute("eternalRestBoard", eternalRestBoardDTO);
        } else {
            eternalRestBoardDTO = eternalRestBoardService.getBoard(erbNo, mno);
            model.addAttribute("eternalRestBoard", eternalRestBoardDTO);
        }
    }

    @GetMapping("/remove") // 게시판 삭제
    public String remove(Long erbNo){

        eternalRestBoardService.remove(erbNo);

        return "redirect:/eternalRest";
    }

    private void sessionReset(MemberDTO memberDTO) {
        // 세션 사용자 정보 업데이트
        UserDetails userDetails = userDetailsService.loadUserByUsername(memberDTO.getMemberId());
        Authentication newAuthentication = new UsernamePasswordAuthenticationToken(userDetails, null, new HashSet<GrantedAuthority>());
        SecurityContextHolder.getContext().setAuthentication(newAuthentication);
    }

}
