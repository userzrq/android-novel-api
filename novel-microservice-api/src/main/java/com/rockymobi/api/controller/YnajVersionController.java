package com.rockymobi.api.controller;


import com.rockymobi.api.entity.YnajApp;
import com.rockymobi.api.entity.YnajVersion;
import com.rockymobi.api.mapper.YnajAppMapper;
import com.rockymobi.api.service.YnajVersionService;
import com.rockymobi.api.vo.AppVersionVo;
import com.rockymobi.common.util.ValidatorUtils;
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

    @Autowired
    private YnajAppMapper appMapper;

    /**
     * 对比App版本接口
     *
     * @return
     */
    @PostMapping("/compareVersion")
    public R compareAppVersion(@RequestBody AppVersionVo vo) {

        log.info("请求版本信息: " + vo.toString());
        ValidatorUtils.validateEntity(vo);
        YnajVersion version = versionService.compareAppVersion(vo);

        YnajApp ynajApp = appMapper.selectById(vo.getAppId());

        YnajVersion submitVersion = versionService.selectByVersionVo(vo);

        if (Objects.isNull(ynajApp)) {
            return R.error().data(null).message("app表中无当前应用，请先添加app相关信息再查询版本");
        }
        if (Objects.isNull(submitVersion)) {
            return R.error().data(null).message("上传版本有误，请重试");
        }
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

