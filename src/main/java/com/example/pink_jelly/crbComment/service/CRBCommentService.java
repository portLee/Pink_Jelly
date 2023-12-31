package com.example.pink_jelly.crbComment.service;

import com.example.pink_jelly.crbComment.dto.CRBCommentDTO;
import com.example.pink_jelly.dto.PageRequestDTO;
import com.example.pink_jelly.dto.PageResponseDTO;

public interface CRBCommentService {
    Long register(CRBCommentDTO crbCommentDTO);
    void remove(Long comNo, Long crbNo);
    PageResponseDTO<CRBCommentDTO> getListCRBComment(Long crbNo, PageRequestDTO pageRequestDTO);

}
