package top.wycfight.thankspring.modules.blog.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wycfight.thankspring.modules.blog.bean.ArticlePostTagEntity;
import top.wycfight.thankspring.modules.blog.mapper.ArticlePostTagMapper;
import top.wycfight.thankspring.modules.blog.service.ArticlePostTagService;
import top.wycfight.thankspring.modules.blog.service.ArticleTagService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 文章/标签 Service
 * @create: 2018-12-29 09:18
 * @modified By:
 **/
@Service("articlePostTagService")
public class ArticlePostTagServiceImpl extends ServiceImpl<ArticlePostTagMapper, ArticlePostTagEntity> implements ArticlePostTagService {
    @Autowired
    private ArticleTagService articleTagService;
    @Override
    public void saveOrUpdate(Long postId, List<String> tagNameList) {
        // 删除之前的文章、标签关系
        deleteBatchId(postId);
        if (tagNameList.size() == 0) {
            return;
        }
        // TODO 保存 看标签中是否存在，如果不存在则保存。，存在 则不保存
        List<Long> tagIds = articleTagService.savePostTag(tagNameList);

        List<ArticlePostTagEntity> articlePostTagEntityList = new ArrayList<>(tagNameList.size());
        tagIds.forEach(tagId -> {
            ArticlePostTagEntity articlePostTagEntity = new ArticlePostTagEntity();
            articlePostTagEntity.setPostId(postId);
            articlePostTagEntity.setTagId(tagId);
            articlePostTagEntityList.add(articlePostTagEntity);
        });
        this.insertBatch(articlePostTagEntityList);

    }

    @Override
    public void deleteBatchId(Long postId) {

    }


}
