package top.wycfight.thankspring.modules.blog.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.common.utils.ResultData;
import top.wycfight.common.validator.ValidatorUtils;
import top.wycfight.common.validator.group.AddGroup;
import top.wycfight.common.validator.group.UpdateGroup;
import top.wycfight.thankspring.common.annotation.SysLog;
import top.wycfight.thankspring.modules.blog.bean.ArticlePostEntity;
import top.wycfight.thankspring.modules.blog.service.ArticlePostService;
import top.wycfight.thankspring.modules.sys.controller.AbstractController;

import java.util.Arrays;
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
    public ResultData list(@RequestParam Map<String, Object> params) {
        PageUtils page = articlePostService.queryPage(params);
        return ResultData.ok().put("page", page);
    }

    /**
     * 根据ID查询文章列表信息
     * @param id 文章ID
     * @return
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("article:post:info")
    public ResultData info(@PathVariable("id") Long id) {
        ArticlePostEntity articlePostEntity = articlePostService.selectById(id);
        ResultData post = ResultData.ok().put("post", articlePostEntity);
        return post;

    }

    /**
     * 保存文章
     *
     * @param articlePostEntity 文章
     * @return
     */
    @SysLog("保存文章")
    @RequestMapping("/save")
    @RequiresPermissions("article:post:save")
    public ResultData save(@RequestBody ArticlePostEntity articlePostEntity) {
        ValidatorUtils.validateEntity(articlePostEntity, AddGroup.class);
        articlePostService.savePostEntity(articlePostEntity);
        return ResultData.ok();
    }

    /**
     * 更新文章
     *
     * @param articlePostEntity 文章
     * @return
     */
    @SysLog("更新文章")
    @RequestMapping("/update")
    @RequiresPermissions("article:post:update")
    public ResultData update(@RequestBody ArticlePostEntity articlePostEntity) {
        ValidatorUtils.validateEntity(articlePostEntity, UpdateGroup.class);
        articlePostService.updatePostEntity(articlePostEntity);
        return ResultData.ok();
    }

    /**
     * 删除文章
     *
     * @param postIds 文章IDs
     * @return
     */
    @SysLog("删除文章")
    @RequestMapping("/delete")
    @RequiresPermissions("article:post:delete")
    public ResultData delete(@RequestBody Long[] postIds) {
        articlePostService.deletePostEntity(Arrays.asList(postIds));
        return ResultData.ok();
    }


}
