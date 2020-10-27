package com.rockymobi.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rockymobi.api.entity.YnajVersion;
import com.rockymobi.api.mapper.YnajVersionMapper;
import com.rockymobi.api.service.YnajVersionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rockymobi.api.vo.AppVersionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author UserZrq
 * @since 2020-10-24
 */
@Service
public class YnajVersionServiceImpl extends ServiceImpl<YnajVersionMapper, YnajVersion> implements YnajVersionService {

    @Autowired
    private YnajVersionMapper versionMapper;

    @Override
    public YnajVersion compareAppVersion(AppVersionVo vo) {
        QueryWrapper<YnajVersion> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(YnajVersion::getClientPhoneType, vo.getClientPhoneType()).eq(YnajVersion::getIsDeleted, 0).orderByDesc(YnajVersion::getCreateTime);
        // 最新版本号
        List<YnajVersion> versions = versionMapper.selectList(wrapper);
        YnajVersion latestVersion = versions.get(0);
        if (Objects.isNull(latestVersion)) {
            return null;
        }
        int i = compareVersion(vo.getAppVersion(), latestVersion.getAppVersion());
        if (i < 0) {
            return latestVersion;
        } else {
            return null;
        }
    }

    private int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            throw new RuntimeException("版本号不能为空");
        }
        //注意此处为正则匹配，不能用.；
        String[] versionArray1 = version1.split("\\.");
        String[] versionArray2 = version2.split("\\.");
        int idx = 0;
        //取最小长度值
        int minLength = Math.min(versionArray1.length, versionArray2.length);
        int diff = 0;
        while (idx < minLength
                //先比较长度
                && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0
                //再比较字符
                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {
            ++idx;
        }
        //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
        diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
        return diff;
    }
}
