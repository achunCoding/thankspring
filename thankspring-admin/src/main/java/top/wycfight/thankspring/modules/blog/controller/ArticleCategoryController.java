package top.wycfight.thankspring.modules.blog.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.common.utils.ResultData;
import top.wycfight.thankspring.modules.blog.bean.ArticleCategoryEntity;
import top.wycfight.thankspring.modules.blog.service.ArticleCategoryService;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 文章分类Controller
 * @create: 2018-12-28 14:53
 * @modified By:
 **/
@RestController
@RequestMapping("/article/category")
public class ArticleCategoryController {

    @Autowired
    private ArticleCategoryService articleCategoryService;

    /**
     * 查询所有分类列表
     *
     * @return
     */
    @RequestMapping("/select")
    @RequiresPermissions("article:category:select")
    public ResultData select() {
        List<ArticleCategoryEntity> categoryEntityList = articleCategoryService.selectList(null);
        return ResultData.ok().put("list", categoryEntityList);
    }



}
