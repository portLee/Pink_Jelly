package com.example.pink_jelly.controller;

import com.example.pink_jelly.dto.MainBoardDTO;
import com.example.pink_jelly.service.MainBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
@RequestMapping({"/main", "/"})
@RequiredArgsConstructor
public class MainBoardController {
    private final MainBoardService mainBoardService;
    @GetMapping("/")
    public String main(){
        System.out.println("main GET ...");
        return "/main/list";
    }
    @GetMapping("write")
    public String write() {
        System.out.println("main write GET...");
        return "/main/write";
    }
    //게시판 등록
    @PostMapping("write")
    public String addPost(MainBoardDTO mainBoardDTO, HttpServletRequest request){
        log.info("/main/write... postMapping");
        mainBoardService.register(mainBoardDTO);
        return "redirect:/main/";
    }

}
