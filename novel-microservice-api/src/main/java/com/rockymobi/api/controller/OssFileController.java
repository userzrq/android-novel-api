package com.rockymobi.api.controller;

import com.rockymobi.api.service.OssFileService;
import com.rockymobi.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@Slf4j
@RequestMapping("/api/oss/file")
public class OssFileController {

    @Autowired
    private OssFileService ossFileService;

    /**
     * oss文件上传接口
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("upload")
    public R fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String fileUploadName = ossFileService.uploadFileToOss(file);
        return R.ok().data("fileName", fileUploadName);
    }


}
