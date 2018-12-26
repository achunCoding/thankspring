package top.wycfight.thankspring.modules.blog.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import top.wycfight.thankspring.modules.sys.bean.SysUserEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: wycfight@163.com
 * @description: 文章/页面
 * @create: 2018-12-24 09:18
 * @modified By:
 **/
@TableName("admin_article_post")
public class ArticlePostEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 文章编号 */
    @TableId
    private Long postId;
    /** 发表用户 多对一 */
    private Long userId;
    /** 文章标题 */
    private String postTitle;
    /** 文章类型 post 文章 page 页面 */
    private String postType;
    /** 文章内容 Markdown格式 */
    private String postContentMd;
    /** 文章内容 HTML格式 */
    private String postContent;
    /** 文章路径 */
    private String postUrl;
    /** 缩略图 */
    private String postThumbnail;
    /** 发表日期 */
    private Date postDate;
    /** 最后一次更新日期 */
    private Date postUpdate;
    /** 0：已发布 1：草稿：2回收站 */
    private Integer postStatus;
    /** 文章访问量  */
    private Long postViews;
    /** 是否 允许评价 */
    private Integer allowComment;
    /** 指定渲染模板 */
    private String customTpl;


    /**
     * 获取：文章编号
     * @return
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * 设置：文章编号
     * @param postId
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * 获取：提交用户ID
     * @return
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置：提交用户ID
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取：文章标题
     * @return
     */
    public String getPostTitle() {
        return postTitle;
    }

    /**
     * 设置：文章标题
     * @param postTitle
     */
    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    /**
     * 获取：文章类型 post 文章 page 页面
     * @return
     */
    public String getPostType() {
        return postType;
    }

    /**
     * 设置：文章类型 post 文章 page 页面
     * @param postType
     */
    public void setPostType(String postType) {
        this.postType = postType;
    }

    /**
     * 获取：文章内容 Markdown格式
     * @return
     */
    public String getPostContentMd() {
        return postContentMd;
    }

    /**
     * 设置：文章内容 Markdown格式
     * @param postContentMd
     */
    public void setPostContentMd(String postContentMd) {
        this.postContentMd = postContentMd;
    }

    /**
     * 获取： 文章内容 HTML格式
     * @return
     */
    public String getPostContent() {
        return postContent;
    }

    /**
     * 设置： 文章内容 HTML格式
     * @param postContent
     */
    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    /**
     * 获取：文章路径
     * @return
     */
    public String getPostUrl() {
        return postUrl;
    }

    /**
     * 设置：文章路径
     * @param postUrl
     */
    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    /**
     * 获取：缩略图
     * @return
     */
    public String getPostThumbnail() {
        return postThumbnail;
    }

    /**
     * 设置：缩略图
     * @param postThumbnail
     */
    public void setPostThumbnail(String postThumbnail) {
        this.postThumbnail = postThumbnail;
    }

    /**
     * 获取：发表日期
     * @return
     */
    public Date getPostDate() {
        return postDate;
    }

    /**
     * 设置：发表日期
     * @param postDate
     */
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    /**
     * 获取:最后一次更新日期
     * @return
     */
    public Date getPostUpdate() {
        return postUpdate;
    }

    /**
     * 设置：最后一次更新日期
     * @param postUpdate
     */
    public void setPostUpdate(Date postUpdate) {
        this.postUpdate = postUpdate;
    }

    /**
     * 获取：0：已发布 1：草稿：2回收站
     * @return
     */
    public Integer getPostStatus() {
        return postStatus;
    }

    /**
     * 设置：0：已发布 1：草稿：2回收站
     * @param postStatus
     */
    public void setPostStatus(Integer postStatus) {
        this.postStatus = postStatus;
    }

    /**
     * 获取：文章访问量
     * @return
     */
    public Long getPostViews() {
        return postViews;
    }

    /**
     * 设置：文章访问量
     * @param postViews
     */
    public void setPostViews(Long postViews) {
        this.postViews = postViews;
    }

    /**
     * 获取：是否 允许评价
     * @return
     */
    public Integer getAllowComment() {
        return allowComment;
    }

    /**
     * 设置：是否 允许评价
     * @param allowComment
     */
    public void setAllowComment(Integer allowComment) {
        this.allowComment = allowComment;
    }

    /**
     * 获取：指定渲染模板
     * @return
     */
    public String getCustomTpl() {
        return customTpl;
    }

    /**
     * 设置：指定渲染模板
     * @param customTpl
     */
    public void setCustomTpl(String customTpl) {
        this.customTpl = customTpl;
    }

    @Override
    public String toString() {
        return "Post{" +
                "文章ID=" + postId +
                ", 提交用户ID=" + userId +
                ", 文章标题='" + postTitle + '\'' +
                ", 文章类型 post 文章 page 页面='" + postType + '\'' +
                ", 文章内容 Markdown格式='" + postContentMd + '\'' +
                ", 文章内容 HTML格式='" + postContent + '\'' +
                ", 文章路径='" + postUrl + '\'' +
                ", 缩略图='" + postThumbnail + '\'' +
                ", 发表日期=" + postDate +
                ", 更新日期=" + postUpdate +
                ", 0：已发布 1：草稿：2回收站=" + postStatus +
                ", 访问量=" + postViews +
                ", 是否 允许评价=" + allowComment +
                ", 指定渲染模板='" + customTpl + '\'' +
                '}';
    }
}
