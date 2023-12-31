package com.example.pink_jelly.crbComment.controller;

import com.example.pink_jelly.crbComment.dto.CRBCommentDTO;
import com.example.pink_jelly.crbComment.service.CRBCommentService;
import com.example.pink_jelly.dto.PageRequestDTO;
import com.example.pink_jelly.dto.PageResponseDTO;
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

@RestController
@Log4j2
@RequestMapping("/crbComment")
@RequiredArgsConstructor
public class CRBCommentController {
    private final CRBCommentService crbCommentService;
    //댓글 등록
    @ApiOperation(value = "Comments POST", notes = "POST 방식으로 댓글 등록")
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> register(@Valid @RequestBody CRBCommentDTO crbCommentDTO, BindingResult bindingResult) throws BindException {
//        log.info("왔습니다j--------------");
        if(bindingResult.hasErrors()) {
            throw new BindException((bindingResult));
        }
        Map<String, Long> resultMap = new HashMap<>();
        Long rno = crbCommentService.register(crbCommentDTO);;

        resultMap.put("rno", rno);

        return resultMap;
    }
    @ApiOperation(value = "Replies of Board", notes = "GET 방식으로 특정 게시물의 댓글 목록")
    @GetMapping(value = "/list/{crbNo}")
    public PageResponseDTO<CRBCommentDTO> getList(@PathVariable("crbNo") Long crbNo, PageRequestDTO pageRequestDTO) {
        // @PathVariable 경로에 있는 값 사용
//        log.info(pageRequestDTO.getSkip());
        log.info("/list/crbNo---------------"+ crbNo + pageRequestDTO.getSkip()+ pageRequestDTO.getSize());

        PageResponseDTO<CRBCommentDTO> crbComment = crbCommentService.getListCRBComment(crbNo, pageRequestDTO);

        return crbComment;
    }

    @ApiOperation(value = "Delete Reply", notes = "DELETE 방식으로 특정 댓글 삭제")
    @DeleteMapping(value = "/{comNo}/{crbNo}")
        public Map<String, Long> remove(@PathVariable("comNo") Long comNo, @PathVariable("crbNo") Long crbNo) {
        crbCommentService.remove(comNo, crbNo);
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("comNo", comNo);
        return resultMap;
    }
}
