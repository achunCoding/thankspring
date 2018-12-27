package top.wycfight.thankspring.modules.blog.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.common.utils.ResultData;
import top.wycfight.thankspring.modules.blog.bean.ArticlePostEntity;
import top.wycfight.thankspring.modules.blog.service.ArticlePostService;
import top.wycfight.thankspring.modules.sys.controller.AbstractController;

import java.util.List;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 文章Controller
 * @create: 2018-12-27 11:29
 * @modified By:
 **/
@RequestMapping("article/post")
@RestController
public class ArticlePostController extends AbstractController {


    @Autowired
    private ArticlePostService articlePostService;

    /**
     * 查询文章列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("article:post:list")
    public ResultData list(@RequestParam Map<String,Object> params) {
        PageUtils page = articlePostService.queryPage(params);
        return ResultData.ok().put("page",page);
    }




}
