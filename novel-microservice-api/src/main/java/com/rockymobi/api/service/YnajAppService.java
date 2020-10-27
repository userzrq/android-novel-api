package com.rockymobi.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rockymobi.api.entity.YnajApp;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author UserZrq
 * @since 2020-10-24
 */
public interface YnajAppService extends IService<YnajApp> {

    Map<String, Object> pageListWeb(Page<YnajApp> pageParam);
}
