package com.sketch.api.controller;

import com.sketch.api.util.Response;
import com.sketch.api.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/oss")
public class OssController {

    private static final String UPLOAD_DIR = "/Users/lingyin/project/self/api-sketch-java/images/";
    private final RestTemplate restTemplate;

    @Autowired
    public OssController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

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

    @GetMapping("/get")
    public Response get(@RequestParam(name="query") String query) {
        String msg = "";
        int code = 0;
        try {
            Response response = this.restTemplate.getForObject("http://localhost:8888/image?query="+query, Response.class);
            if (response != null) {
                return ResponseUtil.response(response.getCode(), response.getMsg(), response.getData());
            }
        } catch (Exception e) {
            code = 1;
            msg = e.getMessage();
        }
        return ResponseUtil.response(code, msg, null);
    }

}
