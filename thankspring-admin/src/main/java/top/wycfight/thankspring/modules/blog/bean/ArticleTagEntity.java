package top.wycfight.thankspring.modules.blog.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @author: wycfight@163.com
 * @description: 文章标签
 * @create: 2018-12-21 14:17
 * @modified By:
 **/
@TableName("admin_article_tag")
public class ArticleTagEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 文章标签ID
     */
    @TableId
    private Long tagId;
    /**
     * 文件标签名称
     */
    private String tagName;
    /**
     * 文章标签URL
     */
    private String tagUrl;

    /**
     * 获取：文章标签ID
     *
     * @return
     */
    public Long getTagId() {
        return tagId;
    }

    /**
     * 设置：文章标签ID
     *
     * @param tagId
     */
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    /**
     * 获取：文章标签名称
     *
     * @return
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * 设置：文章标签名称
     *
     * @param tagName
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * 获取：文章标签Url
     *
     * @return
     */
    public String getTagUrl() {
        return tagUrl;
    }

    /**
     * 设置：文章标签Url
     *
     * @param tagUrl
     */
    public void setTagUrl(String tagUrl) {
        this.tagUrl = tagUrl;
    }

    @Override
    public String toString() {
        return "ArticleTag{" +
                "标签ID：" + tagId +
                ", 标签名称：" + tagName + '\'' +
                ", 标签Url：" + tagUrl + '\'' +
                '}';
    }
}
