package top.wycfight.thankspring.modules.blog.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @author: wycfight@163.com
 * @description: 相册
 * @create: 2018-12-23 19:04
 * @modify By:
 **/
@TableName("article_gallery")
public class ArticleGalleryEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 相册ID */
    @TableId
    private Long galleryId;
    /** 图片名称 */
    private String galleryName;
    /** 图片描述 */
    private String galleryDesc;
    /** 图片日期 / 拍摄日期 */
    private String galleryDate;
    /** 图片拍摄地点 */
    private String galleryLocation;
    /** 图片路径地址 */
    private String galleryThumbnailUrl;
    /** 图片地址 */
    private String galleryUrl;

    /**
     * 获取：相册ID
     * @return
     */
    public Long getGalleryId() {
        return galleryId;
    }

    /**
     * 设置：相册ID
     * @param galleryId
     */
    public void setGalleryId(Long galleryId) {
        this.galleryId = galleryId;
    }

    /**
     * 获取：相册名称
     * @return
     */
    public String getGalleryName() {
        return galleryName;
    }

    /**
     * 设置：相册名称
     * @param galleryName
     */
    public void setGalleryName(String galleryName) {
        this.galleryName = galleryName;
    }

    /**
     * 获取：相冊描述
     * @return
     */
    public String getGalleryDesc() {
        return galleryDesc;
    }

    /**
     * 设置：相冊描述
     * @param galleryDesc
     */
    public void setGalleryDesc(String galleryDesc) {
        this.galleryDesc = galleryDesc;
    }

    /**
     * 获取：相册日期/拍摄日期
     * @return
     */
    public String getGalleryDate() {
        return galleryDate;
    }

    /**
     * 设置：相册日期/拍摄日期
     * @param galleryDate
     */
    public void setGalleryDate(String galleryDate) {
        this.galleryDate = galleryDate;
    }

    /**
     * 获取：图片拍摄地点
     * @return
     */
    public String getGalleryLocation() {
        return galleryLocation;
    }

    /**
     * 设置：图片拍摄地点
     * @param galleryLocation
     */
    public void setGalleryLocation(String galleryLocation) {
        this.galleryLocation = galleryLocation;
    }

    /**
     * 获取：图片路径地址
     * @return
     */
    public String getGalleryThumbnailUrl() {
        return galleryThumbnailUrl;
    }

    /**
     * 设置：图片路径地址
     * @param galleryThumbnailUrl
     */
    public void setGalleryThumbnailUrl(String galleryThumbnailUrl) {
        this.galleryThumbnailUrl = galleryThumbnailUrl;
    }

    /**
     * 获取：图片路径
     * @return
     */
    public String getGalleryUrl() {
        return galleryUrl;
    }

    /**
     * 设置：图片路径
     * @param galleryUrl
     */
    public void setGalleryUrl(String galleryUrl) {
        this.galleryUrl = galleryUrl;
    }

    @Override
    public String toString() {
        return "Gallery{" +
                "相册ID=" + galleryId +
                ", 相册名称='" + galleryName + '\'' +
                ", 相册描述='" + galleryDesc + '\'' +
                ", 相册描述='" + galleryDate + '\'' +
                ", 相册图片拍摄地点='" + galleryLocation + '\'' +
                ", 图片路径地址='" + galleryThumbnailUrl + '\'' +
                ", 图片路径='" + galleryUrl + '\'' +
                '}';
    }
}
