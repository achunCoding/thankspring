package top.wycfight.thankspring.modules.blog.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: wycfight@163.com
 * @description: 附件
 * @create: 2018-12-21 16:54
 * @modified By:
 **/
@TableName("blog_attachment")
public class Attachment implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 附件编号
     */
    @TableId
    private Long attachId;

    /**
     * 附件名
     */
    private String attachName;

    /**
     * 附件路径
     */
    private String attachPath;

    /**
     * 附件缩略图路径
     */
    private String attachSmallPath;

    /**
     * 附件类型
     */
    private String attachType;

    /**
     * 附件后缀
     */
    private String attachSuffix;
    /**
     * 上传时间
     */
    private Date attachCreated;


    /**
     * 附件长宽
     */
    private String attachWh;

    /**
     * 附件存储地址
     */
    private String attachLocation;

    /**
     * 附件来源，0：上传，1：外部链接
     */
    private Integer attachOrigin ;

    /**
     * 获取：附件编号
     * @return
     */
    public Long getAttachId() {
        return attachId;
    }

    /**
     * 设置：附件编号
     * @param attachId
     */
    public void setAttachId(Long attachId) {
        this.attachId = attachId;
    }

    /**
     * 获取：附件名称
     * @return
     */
    public String getAttachName() {
        return attachName;
    }

    /**
     * 设置：附件名称
     * @param attachName
     */
    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    /**
     * 获取：附件路径
     * @return
     */
    public String getAttachPath() {
        return attachPath;
    }

    /**
     * 设置：附件路径
     * @param attachPath
     */
    public void setAttachPath(String attachPath) {
        this.attachPath = attachPath;
    }

    /**
     * 获取：附件缩略图路径
     * @return
     */
    public String getAttachSmallPath() {
        return attachSmallPath;
    }

    /**
     * 设置：附件缩略图路径
     * @param attachSmallPath
     */
    public void setAttachSmallPath(String attachSmallPath) {
        this.attachSmallPath = attachSmallPath;
    }

    /**
     * 获取：附件类型
     * @return
     */
    public String getAttachType() {
        return attachType;
    }

    /**
     * 设置：附件类型
     * @param attachType
     */
    public void setAttachType(String attachType) {
        this.attachType = attachType;
    }

    /**
     * 获取：附件后缀名
     * @return
     */
    public String getAttachSuffix() {
        return attachSuffix;
    }

    /**
     * 设置：附件后缀名
     * @param attachSuffix
     */
    public void setAttachSuffix(String attachSuffix) {
        this.attachSuffix = attachSuffix;
    }

    /**
     * 获取：附件上传时间
     * @return
     */
    public Date getAttachCreated() {
        return attachCreated;
    }

    /**
     * 设置：附件上传时间
     * @param attachCreated
     */
    public void setAttachCreated(Date attachCreated) {
        this.attachCreated = attachCreated;
    }

    /**
     * 获取：附件宽高
     * @return
     */
    public String getAttachWh() {
        return attachWh;
    }

    /**
     * 设置：附件宽高
     * @param attachWh
     */
    public void setAttachWh(String attachWh) {
        this.attachWh = attachWh;
    }

    /**
     * 获取：附件存储地址
     * @return
     */
    public String getAttachLocation() {
        return attachLocation;
    }

    /**
     * 设置：附件存储地址
     * @param attachLocation
     */
    public void setAttachLocation(String attachLocation) {
        this.attachLocation = attachLocation;
    }

    /**
     * 获取：附件来源，0：上传，1：外部链接
     * @return
     */
    public Integer getAttachOrigin() {
        return attachOrigin;
    }

    /**
     * 设置：附件来源，0：上传，1：外部链接
     * @param attachOrigin
     */
    public void setAttachOrigin(Integer attachOrigin) {
        this.attachOrigin = attachOrigin;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "附件ID=" + attachId +
                ", 附件名称='" + attachName + '\'' +
                ", 附件路径='" + attachPath + '\'' +
                ", 附件压缩路径='" + attachSmallPath + '\'' +
                ", 附件类型='" + attachType + '\'' +
                ", 附件后缀='" + attachSuffix + '\'' +
                ", 附件上传时间=" + attachCreated +
                ", 附件宽高='" + attachWh + '\'' +
                ", 附件附件存储地址='" + attachLocation + '\'' +
                ", 附件附件来源=" + attachOrigin +
                '}';
    }
}
