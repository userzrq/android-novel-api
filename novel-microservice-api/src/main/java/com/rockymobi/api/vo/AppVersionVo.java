package com.rockymobi.api.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AppVersionVo {

    private Integer appId;
    /**
     * app类型:1001-IOS终端,1002-Android终端
     */
    private Integer clientPhoneType;
    /**
     * 上传时间，精确到年月日
     */
    private String uploadDate;

    private String appVersion;
}
