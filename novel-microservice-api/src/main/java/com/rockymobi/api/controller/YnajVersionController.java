package com.rockymobi.api.controller;


import com.rockymobi.api.entity.YnajVersion;
import com.rockymobi.api.service.YnajVersionService;
import com.rockymobi.api.vo.AppVersionVo;
import com.rockymobi.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author UserZrq
 * @since 2020-10-24
 */
@Slf4j
@RestController
@RequestMapping("/api/ynaj-version")
public class YnajVersionController {

    @Autowired
    private YnajVersionService versionService;

    /**
     * 对比App版本接口
     *
     * @return
     */
    @PostMapping("/compareVersion")
    public R compareAppVersion(@RequestBody AppVersionVo vo) {

        log.info("请求版本信息: " + vo.toString());
        YnajVersion version = versionService.compareAppVersion(vo);
        if (Objects.isNull(version)) {
            return R.ok().data(null).message("当前版本已经是最新版本");
        }
        Map<String, Object> map = new HashMap<>();

        map.put("appId", version.getAppId());
        map.put("phoneType", version.getClientPhoneType());
        map.put("appVersion", version.getAppVersion());
        map.put("uploadDate", version.getUploadDate());
        map.put("appAddr", version.getAppAddr());
        map.put("updateContent", version.getUpdateContent());
        map.put("forcedUpdate", version.getForcedUpdate());

        return R.ok().data(map).message("发现新版本");

    }

}

