package top.wycfight.thankspring.modules.oss.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: wycfight@163.com
 * @description: 文件上传
 * @create: 2019-01-21 08:36
 * @modified By:
 **/
@TableName("sys_oss")
public class SysOssEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /** ID */
    @TableId
    private Long id;
    /** 存放URL */
    private String url;
    /** 创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    /**
     * 获取：ID
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：ID
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：URL
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置：URL
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：创建时间
     * @return
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置：创建时间
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取：更新时间
     * @return
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置：更新时间
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "SysOssEntity{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", 创建时间=" + createDate +
                ", 更新时间=" + updateDate +
                '}';
    }
}
