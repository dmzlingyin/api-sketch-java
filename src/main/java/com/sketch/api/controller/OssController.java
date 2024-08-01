package com.sketch.api.controller;

import com.sketch.api.util.Response;
import com.sketch.api.util.ResponseUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/oss")
public class OssController {

    private static final String UPLOAD_DIR = "/Users/lingyin/project/self/api-sketch-java/images/";

    @PostMapping("/upload")
    public Response upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseUtil.response(1, "empty file", null);
        }

        try {
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            String fileName = UPLOAD_DIR + file.getOriginalFilename();
            file.transferTo(new File(fileName));
        } catch (Exception e) {
            return ResponseUtil.response(1, e.getMessage(), null);
        }
        // 保存文件
        return ResponseUtil.response(0, "", null);
    }

}
