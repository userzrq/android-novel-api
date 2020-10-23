package com.rockymobi.api.controller;

import com.rockymobi.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/oss/file")
public class OssFileController {

    @PostMapping("upload")
    public R fileUpload(){


    }
}
