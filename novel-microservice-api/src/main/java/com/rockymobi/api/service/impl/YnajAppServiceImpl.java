package com.rockymobi.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rockymobi.api.entity.YnajApp;
import com.rockymobi.api.mapper.YnajAppMapper;
import com.rockymobi.api.service.YnajAppService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author UserZrq
 * @since 2020-10-24
 */
@Service
public class YnajAppServiceImpl extends ServiceImpl<YnajAppMapper, YnajApp> implements YnajAppService {

    /**
     * 将分页对象封装到Map中，用作接口返回对象
     *
     * @param pageParam
     * @return
     */
    @Override
    public Map<String, Object> pageListWeb(Page<YnajApp> pageParam) {

        QueryWrapper<YnajApp> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");

        baseMapper.selectPage(pageParam, wrapper);

        List<YnajApp> records = pageParam.getRecords();
        long current = pageParam.getCurrent();
        long pages = pageParam.getPages();
        long size = pageParam.getSize();
        long total = pageParam.getTotal();
        boolean hasNext = pageParam.hasNext();
        boolean hasPrevious = pageParam.hasPrevious();

        Map<String, Object> map = new HashMap<>();
        map.put("apps", records);
        map.put("current", current);
        map.put("pages", pages);
        map.put("size", size);
        map.put("total", total);
        map.put("hasNext", hasNext);
        map.put("hasPrevious", hasPrevious);

        return map;
    }
}
