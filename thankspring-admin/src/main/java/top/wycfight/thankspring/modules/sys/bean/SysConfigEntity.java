package top.wycfight.thankspring.modules.sys.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: wycfight@163.com
 * @description: 系统配置信息
 * @create: 2019-01-17 11:37
 * @modified By:
 **/
@TableName("sys_config")
public class SysConfigEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 系统配置ID
     */
    @TableId
    private Long id;
    /**
     * 参数名
     */
    @NotBlank(message = "参数名不能为空")
    private String paramKey;
    /**
     * 参数值
     */
    @NotBlank(message = "参数值不能为空")
    private String paramValue;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态 0：隐藏  1：显示
     */
    private Integer status;

    /** 创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    /**
     * 获取：系统配置ID
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：系统配置ID
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：参数名
     * @return
     */
    public String getParamKey() {
        return paramKey;
    }

    /**
     * 设置：参数名
     * @param paramKey
     */
    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    /**
     * 获取：参数值
     * @return
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     * 设置：参数值
     * @param paramValue
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    /**
     * 获取：备注
     * @return
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置：备注
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：状态 0：隐藏 1：显示
     * @return
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置： 状态0：隐藏 1：显示
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取： 创建时间
     * @return
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置： 创建时间
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 设置：更新时间
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
        return "SysConfigEntity{" +
                "id=" + id +
                ", 参数名='" + paramKey + '\'' +
                ", 参数值='" + paramValue + '\'' +
                ", 备注='" + remark + '\'' +
                ", 状态=" + status +
                ", 创建时间=" + createDate +
                ", 更新时间=" + updateDate +
                '}';
    }
}
