package com.rockymobi.api.vo;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class AppVersionVo {

    @NotNull(message = "Invalid appId")
    private Integer appId;
    /**
     * app类型:1001-IOS终端,1002-Android终端
     */
    @NotNull(message = "Invalid phoneType")
    private Integer clientPhoneType;
    /**
     * 上传时间，精确到年月日
     */
    private String uploadDate;

    @NotNull(message = "Invalid appVersion")
    private String appVersion;
}
