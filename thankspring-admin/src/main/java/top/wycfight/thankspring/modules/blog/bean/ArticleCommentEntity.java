package top.wycfight.thankspring.modules.blog.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import top.wycfight.common.validator.group.AddGroup;
import top.wycfight.common.validator.group.UpdateGroup;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 评论
 * @create: 2018-12-23 18:24
 * @modify By:
 **/
@TableName("article_comment")
public class ArticleCommentEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 评论ID 自增 */
    @TableId
    private Long commentId;
    /** 评论人 */
    @NotBlank(message = "评论用户名不能为空",groups = {AddGroup.class,UpdateGroup.class})
    private String commentAuthor;
    /** 评论人邮箱 */
    @Email(message = "邮箱格式不正确")
    @JsonIgnore
    private String commentAuthorEmail;
    /** 评论人的主页 */
    private String commentAutoUrl;
    /** 评论人的IP */
    private String commentAuthorIp;
    /**评论人的头像，用于gavatar */
    private String commentAuthorAvatarMd5;
    /** 评论时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commentDate;
    /** 评论内容 */
    @NotBlank(message = "评论内容不能为空",groups = {AddGroup.class,UpdateGroup.class})
    private String commentContent;
    /** 评论者ua信息 */
    private String commentAgent;
    /** 上一级 */
    private Long commentParent;
    /** 评论状态：0：正常，1：待审核，2：回收站 */
    private Integer commentStatus;
    /** 是否是博主的评论 0：不是 1：是 */
    private Integer isAdmin;
    /** 当前评论下的所有子评论 */
    private List<ArticleCommentEntity> childComments;
    /** 文章ID */
    private Long postId;

    /**
     * 获取：评论ID
     * @return
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * 设置：评论ID
     * @param commentId
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取：评论作者
     * @return
     */
    public String getCommentAuthor() {
        return commentAuthor;
    }

    /**
     * 设置：评论作者
     * @param commentAuthor
     */
    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    /**
     * 获取：评论人邮箱
     * @return
     */
    public String getCommentAuthorEmail() {
        return commentAuthorEmail;
    }

    /**
     * 设置：评论人邮箱
     * @param commentAuthorEmail
     */
    public void setCommentAuthorEmail(String commentAuthorEmail) {
        this.commentAuthorEmail = commentAuthorEmail;
    }

    /**
     * 获取：评论人的主页
     * @return
     */
    public String getCommentAutoUrl() {
        return commentAutoUrl;
    }

    /**
     * 设置：评论人的主页
     * @param commentAutoUrl
     */
    public void setCommentAutoUrl(String commentAutoUrl) {
        this.commentAutoUrl = commentAutoUrl;
    }

    /**
     * 获取：评论人IP
     * @return
     */
    public String getCommentAuthorIp() {
        return commentAuthorIp;
    }

    /**
     * 设置：评论人IP
     * @param commentAuthorIp
     */
    public void setCommentAuthorIp(String commentAuthorIp) {
        this.commentAuthorIp = commentAuthorIp;
    }

    /**
     * 获取：评论人的头像
     * @return
     */
    public String getCommentAuthorAvatarMd5() {
        return commentAuthorAvatarMd5;
    }

    /**
     * 设置：评论人的头像
     * @param commentAuthorAvatarMd5
     */
    public void setCommentAuthorAvatarMd5(String commentAuthorAvatarMd5) {
        this.commentAuthorAvatarMd5 = commentAuthorAvatarMd5;
    }

    /**
     * 获取：提交时间
     * @return
     */
    public Date getCommentDate() {
        return commentDate;
    }

    /**
     * 设置：提交时间
     * @param commentDate
     */
    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    /**
     * 获取：评论内容
     * @return
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * 设置：评论内容
     * @param commentContent
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    /**
     * 获取：评论者ua信息
     * @return
     */
    public String getCommentAgent() {
        return commentAgent;
    }

    /**
     * 设置：评论者ua信息
     * @param commentAgent
     */
    public void setCommentAgent(String commentAgent) {
        this.commentAgent = commentAgent;
    }

    /**
     * 获取：上一级
     * @return
     */
    public Long getCommentParent() {
        return commentParent;
    }

    /**
     * 设置：上一级
     * @param commentParent
     */
    public void setCommentParent(Long commentParent) {
        this.commentParent = commentParent;
    }

    /**
     * 获取：评论状态：0：正常，1：待审核，2：回收站
     * @return
     */
    public Integer getCommentStatus() {
        return commentStatus;
    }

    /**
     * 设置：评论状态：0：正常，1：待审核，2：回收站
     * @param commentStatus
     */
    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    /**
     * 获取：是否Admin
     * @return
     */
    public Integer getIsAdmin() {
        return isAdmin;
    }

    /**
     * 设置：是否Admin
     * @param isAdmin
     */
    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * 获取：当前评论下的所有子评论
     * @return
     */
    public List<ArticleCommentEntity> getChildComments() {
        return childComments;
    }

    /**
     * 设置：当前评论下的所有子评论
     * @param childComments
     */
    public void setChildComments(List<ArticleCommentEntity> childComments) {
        this.childComments = childComments;
    }

    /**
     * 获取:文章ID
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

    @Override
    public String toString() {
        return "Comment{" +
                "评论ID=" + commentId +
                ", 评论者='" + commentAuthor + '\'' +
                ", 评论者邮箱='" + commentAuthorEmail + '\'' +
                ", 评论者Url='" + commentAutoUrl + '\'' +
                ", 评论者Ip='" + commentAuthorIp + '\'' +
                ", 评论者头像='" + commentAuthorAvatarMd5 + '\'' +
                ", 提交时间=" + commentDate +
                ", 提交内容='" + commentContent + '\'' +
                ", 评论者ua信息='" + commentAgent + '\'' +
                ", 上一级=" + commentParent +
                ", 提交状态=" + commentStatus +
                ", 是否是博主=" + isAdmin +
                ", 文章ID="+postId +
                '}';
    }
}
