package com.rockymobi.api.controller.admin;


import com.rockymobi.api.service.YnajChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * admin 包下是暴露给前端的接口
 * </p>
 *
 * @author UserZrq
 * @since 2020-10-20
 */
@RestController
@RequestMapping("/android/admin/chapter")
public class ChapterAdminController {

    @Autowired
    private YnajChapterService ynajChapterService;
}

