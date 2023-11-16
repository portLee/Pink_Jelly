package com.example.pink_jelly.controller;

import com.example.pink_jelly.dto.MainBoardDTO;
import com.example.pink_jelly.dto.MemberDTO;
import com.example.pink_jelly.dto.PageRequestDTO;
import com.example.pink_jelly.dto.PageResponseDTO;
import com.example.pink_jelly.service.MainBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.security.Principal;

@Log4j2
@Controller
@RequestMapping({"/main", "/"})
@RequiredArgsConstructor
public class MainBoardController {
    @Value("${com.example.mainBoardUpload.path}")
    private String mainBoardPath;
    private final MainBoardService mainBoardService;

    @GetMapping("")
    public String main(Model model, PageRequestDTO pageRequestDTO, Long mno, String memberId, @AuthenticationPrincipal MemberDTO memberDTO) {
        log.info("main GET ...");
        log.info("메인 멤버디티오 : " + memberDTO);
        log.info("타입은? : " + pageRequestDTO.getType());
        log.info("키워드는? : " + pageRequestDTO.getKeyword());

        if(memberDTO != null){
            String loginId = memberDTO.getMemberId();
            Long loginMno = memberDTO.getMno();
            PageResponseDTO<MainBoardDTO> mainBoardList = mainBoardService.getList(pageRequestDTO, loginMno, loginId);
            model.addAttribute("mainBoardList", mainBoardList);
            mainBoardList.getDtoList().forEach(log::info);
        } else {
            PageResponseDTO<MainBoardDTO> mainBoardList = mainBoardService.getList(pageRequestDTO, mno, memberId);
            model.addAttribute("mainBoardList", mainBoardList);
            mainBoardList.getDtoList().forEach(log::info);
        }

        return "/main/list";
    }

    //글쓰기 페이지 이동
    @GetMapping("/write")
    public void write() {
        System.out.println("main write GET...");
    }

    @GetMapping({"/view", "/modify"})
    public void view(Long mbNo, Model model,Long mno ,HttpServletRequest request, @AuthenticationPrincipal MemberDTO memberDTO) {
        log.info("/main/view GET...");
        log.info(mbNo);
        MainBoardDTO mainBoardDTO = null;
        String requestedUrl = request.getRequestURI();
        // 로그인 한 놈 들고와

        if(memberDTO != null){
            mno = memberDTO.getMno();
            if (requestedUrl.equals("/main/view")) {
                mainBoardDTO = mainBoardService.getBoard(mbNo, "view", mno);
                mainBoardDTO.setFlag(mainBoardService.isBoardLike(mno, mbNo));
            } else {
                mainBoardDTO = mainBoardService.getBoard(mbNo, "modify", mno);
            }
            log.info(mainBoardDTO);
            model.addAttribute("mainBoard", mainBoardDTO);
        } else {
            if (requestedUrl.equals("/main/view")) {
                mainBoardDTO = mainBoardService.getBoard(mbNo, "view", mno);

            } else {
                mainBoardDTO = mainBoardService.getBoard(mbNo, "modify", mno);
            }
            log.info(mainBoardDTO);
            model.addAttribute("mainBoard", mainBoardDTO);
        }

    }

    //게시판 등록
    @PostMapping("/write")
    public String write(MainBoardDTO mainBoardDTO, HttpServletRequest request) {
        log.info("/main/write... postMapping");
        mainBoardService.register(mainBoardDTO);
        return "redirect:/main";
    }

    //게시판 삭제
    @GetMapping("/remove")
    public String remove(Long mbNo, @AuthenticationPrincipal MemberDTO memberDTO) {
        Long mno = memberDTO.getMno();
        MainBoardDTO mainBoardDTO = mainBoardService.getBoard(mbNo, "remove", mno);
        List<String> files = mainBoardDTO.getMainImg();

        if(files != null && files.size() > 0) {
            removeFiles(files);
            log.info("removeFiles----------------");

        }
        mainBoardService.removeOne(mbNo);
        return "redirect:/main";
    }
    public void removeFiles(List<String> files) {
        for(String fileName:files) {
            Resource resource = new FileSystemResource(mainBoardPath + File.separator + fileName);
            log.info(resource);
            try{
                String contentType = Files.probeContentType(resource.getFile().toPath());
                resource.getFile().delete();

                //섬네일이 존재한다면
                if(contentType.startsWith("image")) {
                    File thumbFile = new File(mainBoardPath + File.separator + "s_" + fileName);
                    thumbFile.delete();
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

    @PostMapping("/modify")
    public String modify(MainBoardDTO mainBoardDTO, Model model) {
        log.info("Post modify");
        log.info(mainBoardDTO);
        mainBoardService.modifyBoard(mainBoardDTO);
        return "redirect:/main/view?mbNo=" + mainBoardDTO.getMbNo();
    }

}