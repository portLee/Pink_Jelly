package com.example.pink_jelly.mainComment.controller;

import com.example.pink_jelly.dto.PageRequestDTO;
import com.example.pink_jelly.dto.PageResponseDTO;
import com.example.pink_jelly.mainComment.dto.MainCommentDTO;
import com.example.pink_jelly.mainComment.service.MainCommentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/mainComment")
@RequiredArgsConstructor //의존성 주입
public class MainCommentController {
    private final MainCommentService mainCommentService;

    @ApiOperation(value = "Comments POST", notes = "POST 방식으로 댓글 등록")
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> register(@Valid @RequestBody MainCommentDTO mainCommentDTO, BindingResult bindingResult) throws BindException {
//        log.info("왔습니다--------------");
        if(bindingResult.hasErrors()) {
        throw new BindException((bindingResult));
    }
        log.info("hello"+mainCommentDTO.getProfileImg());
        Map<String, Long> resultMap = new HashMap<>();
        Long rno = mainCommentService.register(mainCommentDTO);;

        resultMap.put("rno", rno);

        return resultMap;
    }
    @ApiOperation(value = "Replies of Board", notes = "GET 방식으로 특정 게시물의 댓글 목록")
    @GetMapping(value = "/list/{mbNo}")
    public PageResponseDTO<MainCommentDTO> getList(@PathVariable("mbNo") Long mbNo, PageRequestDTO pageRequestDTO) {
        log.info("/list/crbNo---------------"+ mbNo + pageRequestDTO.getSkip()+ pageRequestDTO.getSize());

        PageResponseDTO<MainCommentDTO> mainComment = mainCommentService.getListMainComment(mbNo, pageRequestDTO);

        return mainComment;
    }

    @ApiOperation(value = "Replies of Board", notes = "GET 방식으로 특정 게시물의 댓글 목록 최신순")
    @GetMapping(value = "/comments/{mbNo}")
    public PageResponseDTO<MainCommentDTO> getCommentList(@PathVariable("mbNo") Long mbNo, PageRequestDTO pageRequestDTO) {
        log.info("/list/crbNo---------------");
        log.info(mbNo);
        log.info(pageRequestDTO);

        PageResponseDTO<MainCommentDTO> responseDTO = mainCommentService.getMainCommentList(mbNo, pageRequestDTO);

        return responseDTO;
    }

    @ApiOperation(value = "Delete Reply", notes = "DELETE 방식으로 특정 댓글 삭제")
    @DeleteMapping(value = "/{comNo}/{mbNo}")
    public Map<String, Long> remove(@PathVariable("comNo") Long comNo, @PathVariable("mbNo") Long mbNo) {

        mainCommentService.remove(comNo, mbNo);
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("comNo", comNo);
        return resultMap;
    }

}
