package com.example.pink_jelly.dto.upload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class EditorUploadDTO {
    private MultipartFile filedata;
    private String callback;
    private String callback_func;
}
