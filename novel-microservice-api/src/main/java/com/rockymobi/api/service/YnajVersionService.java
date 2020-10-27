package com.rockymobi.api.service;

import com.rockymobi.api.entity.YnajVersion;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rockymobi.api.vo.AppVersionVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author UserZrq
 * @since 2020-10-24
 */
public interface YnajVersionService extends IService<YnajVersion> {

    /**
     * 比较上传app版本与当前版本
     * @param vo
     * @return
     */
    YnajVersion compareAppVersion(AppVersionVo vo);
}
