package top.wycfight.thankspring.modules.blog.bean;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @author: wycfight@163.com
 * @description: 文章 、分类 中间表
 * @create: 2018-12-24 15:15
 * @modified By:
 **/
@TableName("article_post_category")
public class ArticlePostCategoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 分类/文章ID */
    private Long id;
    /** 文章ID */
    private Long postId;
    /** 分类ID */
    private Long categoryId;

    /**
     * 获取：分类/文章ID
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：分类/文章ID
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：文章ID
     * @return
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置：文章ID
     * @param postId
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * 获取：分类ID
     * @return
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置：分类ID
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ArticlePostCategoryEntity{" +
                "id=" + id +
                ", 文章ID=" + postId +
                ", 分类ID=" + categoryId +
                '}';
    }
}
