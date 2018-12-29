package top.wycfight.thankspring.modules.blog.service;

import com.baomidou.mybatisplus.service.IService;
import top.wycfight.thankspring.modules.blog.bean.ArticleTagEntity;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 标签Service
 * @create: 2018-12-29 09:14
 * @modified By:
 **/
public interface ArticleTagService extends IService<ArticleTagEntity> {
    /**
     * 保存标签，是否查看数据库是否有此数据 有则不存，没有则存
     * @param tagNames
     * @return
     */
    List<Long> savePostTag(List<String> tagNames);
}
