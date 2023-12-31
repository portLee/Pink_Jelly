package com.example.pink_jelly.catsMe.controller;

import com.example.pink_jelly.catsMe.dto.CatsReviewBoardDTO;
import com.example.pink_jelly.catsMe.dto.CatsMeBoardDTO;
import com.example.pink_jelly.catsMe.service.CatsMeService;
import com.example.pink_jelly.dto.*;
import com.example.pink_jelly.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catsMeTab")
@RequiredArgsConstructor
@Log4j2
public class CatsMeTabController {
    private final CatsMeService catsMeService;

    @GetMapping("/board")
    public ResponseEntity<PageResponseDTO<CatsMeBoardDTO>>catsMeTab(PageRequestDTO pageRequestDTO, Long mno, String memberId, @AuthenticationPrincipal MemberDTO memberDTO){
        log.info("/board...");
        log.info(pageRequestDTO);

        PageResponseDTO<CatsMeBoardDTO> response;
        if(memberDTO != null){
            String loginId = memberDTO.getMemberId();
            Long loginMno = memberDTO.getMno();
            response = catsMeService.getList(pageRequestDTO, loginMno, loginId);
        }else{
            response = catsMeService.getList(pageRequestDTO, mno, memberId);
        }

       return ResponseEntity.ok(response);
    }

    @GetMapping("/review")
    public ResponseEntity<PageResponseDTO<CatsReviewBoardDTO>>catsReviewTab(PageRequestDTO pageRequestDTO, Long mno, String memberId, @AuthenticationPrincipal MemberDTO memberDTO){
        log.info("/review...");
        log.info(pageRequestDTO);
        PageResponseDTO<CatsReviewBoardDTO> response;

        if(memberDTO != null){
            String loginId = memberDTO.getMemberId();
            Long loginMno = memberDTO.getMno();
            response = catsMeService.getReviewBoardList(pageRequestDTO, loginMno, loginId);
        }else{
            response = catsMeService.getReviewBoardList(pageRequestDTO, mno, memberId);
        }

        return ResponseEntity.ok(response);
    }
}
