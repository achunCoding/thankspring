package top.wycfight.thankspring.modules.blog.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.common.utils.Query;
import top.wycfight.thankspring.modules.blog.bean.ArticlePostEntity;
import top.wycfight.thankspring.modules.blog.mapper.ArticlePostMapper;
import top.wycfight.thankspring.modules.blog.service.ArticlePostService;
import top.wycfight.thankspring.modules.blog.service.ArticlePostTagService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 文章Service
 * @create: 2018-12-27 11:27
 * @modified By:
 **/
@Service("articlePostService")
public class ArticlePostServiceImpl extends ServiceImpl<ArticlePostMapper, ArticlePostEntity> implements ArticlePostService {

    @Autowired
    private ArticlePostTagService articlePostTagService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String postTitle = (String) params.get("postTitle");
        String postStatus = (String) params.get("postStatus");
        Page<ArticlePostEntity> page = this.selectPage(
                new Query<ArticlePostEntity>(params).getPage(),
                new EntityWrapper<ArticlePostEntity>().like(StringUtils.isNotBlank(postTitle), "post_title", postTitle)
                        .like(StringUtils.isNotBlank(postStatus), "post_status", postStatus)
        );
        return new PageUtils(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void savePostEntity(ArticlePostEntity articlePostEntity) {
        articlePostEntity.setPostDate(new Date());
        articlePostEntity.setPostUpdate(new Date());
        this.insert(articlePostEntity);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deletePostEntity(List<Long> postIdList) {
        this.deleteBatchIds(postIdList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updatePostEntity(ArticlePostEntity articlePostEntity) {
        articlePostEntity.setPostUpdate(new Date());
        this.updateById(articlePostEntity);

    }


}
