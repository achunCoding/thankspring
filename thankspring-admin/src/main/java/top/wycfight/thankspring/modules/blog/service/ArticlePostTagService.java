package top.wycfight.thankspring.modules.blog.service;

import com.baomidou.mybatisplus.service.IService;
import top.wycfight.thankspring.modules.blog.bean.ArticlePostEntity;
import top.wycfight.thankspring.modules.blog.bean.ArticlePostTagEntity;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 文章/标签 Service
 * @create: 2018-12-29 09:17
 * @modified By:
 **/
public interface ArticlePostTagService extends IService<ArticlePostTagEntity> {
    /**
     * 保存、更新 标签分类
     * @param postId
     * @param tagNameList
     */
    void saveOrUpdate(Long postId, List<String> tagNameList);

    /**
     * 删除之前文章和标签之前的关系
     * @param postId
     */
    void deleteBatchId(Long postId);
}
