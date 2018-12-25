package top.wycfight.thankspring.modules.blog.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @author: wycfight@163.com
 * @description: 文章/标签 中间表
 * @create: 2018-12-24 15:34
 * @modified By:
 **/
@TableName("article_post_tag")
public class ArticlePostTagEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 文章标签ID */
    @TableId
    private Long id;
    /** 文章id */
    private Long postId;
    /** 文章标签ID */
    private Long tagId;

    /**
     * 获取：文章标签ID
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：文章标签ID
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
     * 获取：文章标签ID
     * @return
     */
    public Long getTagId() {
        return tagId;
    }

    /**
     * 设置：文章标签ID
     * @param tagId
     */
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "ArticlePostTagEntity{" +
                "id=" + id +
                ", 文章ID=" + postId +
                ", 标签ID=" + tagId +
                '}';
    }
}
