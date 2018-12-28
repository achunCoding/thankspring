package top.wycfight.thankspring.modules.blog.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import top.wycfight.common.validator.group.AddGroup;
import top.wycfight.common.validator.group.UpdateGroup;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: wycfight@163.com
 * @description: 文章分类
 * @create: 2018-12-21 17:15
 * @modified By:
 **/
@TableName("article_category")
public class ArticleCategoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 分类ID */
    @TableId
    private Long cateId;
    /** 分类名称 */
    @NotBlank(message = "分类名称不能为空",groups = {AddGroup.class,UpdateGroup.class})
    private String cateName;
//    /** 分类路径 */
//    @NotBlank(message = "分类路径不能为空",groups = {AddGroup.class,UpdateGroup.class})
//    private String cateUrl;
//    /** 分类描述 */
//    private String cateDesc;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 获取：分类ID
     * @return
     */
    public Long getCateId() {
        return cateId;
    }

    /**
     * 设置：分类ID
     * @param cateId
     */
    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    /**
     * 获取：分类名称
     * @return
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * 设置：分类名称
     * @param cateName
     */
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

//    /**
//     * 获取：分类URL
//     * @return
//     */
//    public String getCateUrl() {
//        return cateUrl;
//    }
//
//    /**
//     * 设置：分类URL
//     * @param cateUrl
//     */
//    public void setCateUrl(String cateUrl) {
//        this.cateUrl = cateUrl;
//    }
//
//    /**
//     * 获取：分类描述
//     * @return
//     */
//    public String getCateDesc() {
//        return cateDesc;
//    }
//
//    /**
//     * 设置：分类描述
//     * @param cateDesc
//     */
//    public void setCateDesc(String cateDesc) {
//        this.cateDesc = cateDesc;
//    }

    /**
     * 获取：更新时间
     * @return
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：创建时间
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：更新时间
     * @return
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置：更新时间
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Category{" +
                "分类ID=" + cateId +
                ", 分类名称='" + cateName + '\'' +
                ", 创建时间=" + createTime +
                ", 更新时间=" + updateTime +
                '}';
    }
}
