package top.wycfight.thankspring.modules.sys.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: wycfight@163.com
 * @description: 数据字典
 * @create: 2019-01-17 14:30
 * @modified By:
 **/
@TableName("sys_dict")
public class SysDictEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 字典名称
     */
    @TableId
    private Long id;
    /**
     * 字典名称
     */
    @NotBlank(message = "字典名称不能为空")
    private String name;
    /**
     * 字典类型
     */
    @NotBlank(message = "字典类型不能为空")
    private String type;
    /**
     * 字典码
     */
    @NotBlank(message = "字典码不能为空")
    private String code;
    /**
     * 字典值
     */
    @NotBlank(message = "字典值不能为空")
    private String value;
    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标记  -1：已删除  0：正常
     */
    @TableLogic
    private Integer delFlag;

    /** 创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    /**
     * 获取：数据字典ID
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：数据字典ID
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：数据字典名称
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置： 数据字典名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取： 数据字典名称
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * 设置：数据字典名称
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取： 数据字典码
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置： 数据字典码
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取： 数据字典值
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置：数据字典值
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取： 排序
     * @return
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置： 排序
     * @param orderNum
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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
     * 删除标记  -1：已删除  0：正常
     * @return
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 删除标记  -1：已删除  0：正常
     * @param delFlag
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
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
        return "SysDictEntity{" +
                "id=" + id +
                ", 字典名称='" + name + '\'' +
                ", 字典类型='" + type + '\'' +
                ", 字典码='" + code + '\'' +
                ", 字典值='" + value + '\'' +
                ", 排序=" + orderNum +
                ", 备注='" + remark + '\'' +
                ", 删除状态=" + delFlag +
                ", 创建时间=" + createDate +
                ", 更新时间=" + updateDate +
                '}';
    }
}
