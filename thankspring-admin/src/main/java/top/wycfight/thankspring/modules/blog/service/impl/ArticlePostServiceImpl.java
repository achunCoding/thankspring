package top.wycfight.thankspring.modules.blog.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import top.wycfight.common.utils.PageUtils;
import top.wycfight.thankspring.common.utils.Query;
import top.wycfight.thankspring.modules.blog.bean.ArticlePostEntity;
import top.wycfight.thankspring.modules.blog.mapper.ArticlePostMapper;
import top.wycfight.thankspring.modules.blog.service.ArticlePostService;
import top.wycfight.thankspring.modules.sys.bean.SysLogEntity;

import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 文章Service
 * @create: 2018-12-27 11:27
 * @modified By:
 **/
@Service("articlePostService")
public class ArticlePostServiceImpl extends ServiceImpl<ArticlePostMapper, ArticlePostEntity> implements ArticlePostService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String)params.get("key");
        Page<ArticlePostEntity> page = this.selectPage(
                new Query<ArticlePostEntity>(params).getPage(),
                new EntityWrapper<ArticlePostEntity>().like(StringUtils.isNotBlank(key),"username", key)
        );
        return new PageUtils(page);
    }
}
