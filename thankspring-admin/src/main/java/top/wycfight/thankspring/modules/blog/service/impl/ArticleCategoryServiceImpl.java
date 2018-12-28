package top.wycfight.thankspring.modules.blog.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wycfight.thankspring.modules.blog.bean.ArticleCategoryEntity;
import top.wycfight.thankspring.modules.blog.mapper.ArticleCategoryMapper;
import top.wycfight.thankspring.modules.blog.service.ArticleCategoryService;



/**
 * @author: wycfight@163.com
 * @description: 文章分类Service
 * @create: 2018-12-28 14:54
 * @modified By:
 **/
@Service("articleCategoryService")
public class ArticleCategoryServiceImpl extends ServiceImpl<ArticleCategoryMapper, ArticleCategoryEntity> implements ArticleCategoryService {

}
