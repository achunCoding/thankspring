package top.wycfight.thankspring.modules.blog.service;

import com.baomidou.mybatisplus.service.IService;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.modules.blog.bean.ArticlePostEntity;

import java.util.List;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 文章Service
 * @create: 2018-12-27 11:27
 * @modified By:
 **/
public interface ArticlePostService extends IService<ArticlePostEntity> {
    /**
     * 查询到所有文章列表
     * @param params 列表参数
     * @return
     */
    PageUtils queryPage(Map<String,Object> params);

    /**
     * 保存文章
     * @param articlePostEntity 文章
     */
    void save(ArticlePostEntity articlePostEntity);

    /**
     * 删除文章列表
     * @param postIdList 文章ID列表
     */
    void deletePostEntity(List<Long> postIdList);
}
