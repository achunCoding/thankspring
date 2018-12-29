package top.wycfight.thankspring.modules.blog.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wycfight.thankspring.modules.blog.bean.ArticleTagEntity;
import top.wycfight.thankspring.modules.blog.mapper.ArticleTagMapper;
import top.wycfight.thankspring.modules.blog.service.ArticleTagService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: wycfight@163.com
 * @description: 文章标签Service
 * @create: 2018-12-29 09:15
 * @modified By:
 **/
@Service("articleTagService")
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTagEntity> implements ArticleTagService {
    @Override
    public List<Long> savePostTag(List<String> tagNames) {
        // 查询所有标签列表
        List<Long> result = new ArrayList<>(tagNames.size());
        List<ArticleTagEntity> articleTagEntities = this.selectList(null);
        List<ArticleTagEntity> saveArticleTagList = new ArrayList<>();
        if (articleTagEntities.size() > 0) {
            articleTagEntities.forEach(articleTagEntity -> {
                tagNames.forEach(tagName -> {
                    if (articleTagEntity.getTagName().equals(tagName)) {
                        result.add(articleTagEntity.getTagId());
                    }
                });
            });
            tagNames.retainAll(saveArticleTagList.stream().map(ArticleTagEntity::getTagName).collect(Collectors.toList()));
        }
            tagNames.forEach(tagName -> {
                ArticleTagEntity articleTagEntity = new ArticleTagEntity();
                articleTagEntity.setTagName(tagName);
                saveArticleTagList.add(articleTagEntity);
            });

        if (saveArticleTagList.size() > 0) {
            this.insertBatch(saveArticleTagList);
        }
        List<Long> resultIds = saveArticleTagList.stream().map(ArticleTagEntity::getTagId).collect(Collectors.toList());
        result.addAll(resultIds);
        return result;
    }



}
