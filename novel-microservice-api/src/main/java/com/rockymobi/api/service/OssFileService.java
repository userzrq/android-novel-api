package com.rockymobi.api.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface OssFileService {

    /**
     * 上传文件至阿里云Oss
     * @param file
     * @return
     * @throws IOException
     */
    String uploadFileToOss(MultipartFile file) throws IOException;
}
