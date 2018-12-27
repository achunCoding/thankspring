package top.wycfight.thankspring.modules.blog.bean;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @author: wycfight@163.com
 * @description: 友情链接
 * @create: 2018-12-24 15:27
 * @modified By:
 **/
@TableName("article_link")
public class ArticleLinkEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 友情链接ID */
    private Long linkId;
    /** 友情链接名称 */
    private String linkName;
    /** 友情链接url */
    private String linkUrl;
    /** 友情链接头像 */
    private String linkPic;
    /** 友情链接描述  */
    private String linkDesc;

    /**
     * 获取：友情链接ID
     * @return
     */
    public Long getLinkId() {
        return linkId;
    }

    /**
     * 设置：友情链接ID
     * @param linkId
     */
    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    /**
     * 获取：友情链接名称
     * @return
     */
    public String getLinkName() {
        return linkName;
    }

    /**
     * 设置：友情链接名称
     * @param linkName
     */
    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    /**
     * 获取：友情链接url
     * @return
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * 设置：友情链接url
     * @param linkUrl
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    /**
     * 获取：友情链接头像
     * @return
     */
    public String getLinkPic() {
        return linkPic;
    }

    /**
     * 设置：友情链接头像
     * @param linkPic
     */
    public void setLinkPic(String linkPic) {
        this.linkPic = linkPic;
    }

    /**
     * 获取：友情链接描述
     * @return
     */
    public String getLinkDesc() {
        return linkDesc;
    }

    /**
     * 设置：友情链接描述
     * @param linkDesc
     */
    public void setLinkDesc(String linkDesc) {
        this.linkDesc = linkDesc;
    }

    @Override
    public String toString() {
        return "ArticleLinkEntity{" +
                "友情链接ID=" + linkId +
                ", 友情链接名称='" + linkName + '\'' +
                ", 友情链接url='" + linkUrl + '\'' +
                ", 友情链接头像='" + linkPic + '\'' +
                ", 友情链接描述='" + linkDesc + '\'' +
                '}';
    }
}
