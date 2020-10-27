package com.rockymobi.api.service.impl;

import com.aliyun.oss.OSSClient;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rockymobi.api.service.OssFileService;
import com.rockymobi.api.util.OssConstantPropertyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author 10017
 */
@Slf4j
@Service
public class OssFileServiceImpl implements OssFileService {

    String endpoint = OssConstantPropertyUtils.END_POINT;
    String keyId = OssConstantPropertyUtils.KEY_ID;
    String keySecret = OssConstantPropertyUtils.KEY_SECRET;
    String bucketName = OssConstantPropertyUtils.BUCKET_NAME;

    @Override
    public String uploadFileToOss(MultipartFile file) throws IOException {

        log.info("endpoint: {}", endpoint);
        log.info("keyId: {}", keyId);
        log.info("keySecret: {}", keySecret);
        log.info("bucketName: {}", bucketName);

        // 创建OSSClient实例
        String fileName = file.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        String newFileName = UUID.randomUUID().toString() + fileSuffix;
        OSSClient ossClient = new OSSClient(endpoint, keyId, keySecret);
        ossClient.putObject(bucketName, newFileName, new ByteArrayInputStream(file.getBytes()));
        // 关闭client
        ossClient.shutdown();
        // URL过期时间
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        String url = ossClient.generatePresignedUrl(bucketName, newFileName, expiration).toString();

        // ?
        String[] uurrll = url.split("\\?");
        //System.out.println(uurrll[0]);
        return url;
    }

}
