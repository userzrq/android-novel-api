package com.rockymobi.api.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rockymobi.api.entity.YnajApp;
import com.rockymobi.api.service.YnajAppService;
import com.rockymobi.common.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author UserZrq
 * @since 2020-10-24
 */
@RestController
@RequestMapping("/api/ynaj-app")
public class YnajAppController {

    @Autowired
    YnajAppService ynajAppService;

    /**
     *
     */
    @GetMapping(value = "{page}/{limit}")
    public R getAppId(@PathVariable Long page, @PathVariable Long limit) {
        Page<YnajApp> pageParam = new Page<>(page, limit);

        Map<String,Object> map = ynajAppService.pageListWeb(pageParam);
        return R.ok().data(map);
    }
}

