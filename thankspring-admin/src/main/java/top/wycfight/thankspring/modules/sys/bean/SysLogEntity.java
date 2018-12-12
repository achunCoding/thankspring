package top.wycfight.thankspring.modules.sys.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: wycfight@163.com
 * @description: 系统日志
 * @create: 2018-12-10 13:56
 * @modified By:
 **/
@TableName("sys_log")
public class SysLogEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    /** 用户名 */
    private String username;
    /** 用户操作 */
    private String operation;
    /** 请求方法 */
    private String method;
    /** 请求参数 */
    private String params;
    /** 执行时长(毫秒) */
    private Long time;
    /** IP地址 */
    private String ip;
    /** 创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

    /**
     * 获取ID
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：用户名
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置：用户名
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取： 用户操作
     * @return
     */
    public String getOperation() {
        return operation;
    }

    /**
     * 设置： 用户操作
     * @param operation
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * 获取： 请求方法
     * @return
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置：请求方法
     * @param method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取：执行时长
     * @return
     */
    public Long getTime() {
        return time;
    }

    /**
     * 设置：执行时长
     * @param time
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * 获取： IP地址
     * @return
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置：IP地址
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
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
     * 获取： 更新时间
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

    /**
     * 获取： 请求参数
     * @return
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置： 请求参数
     * @param params
     */
    public void setParams(String params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "SysLogEntity{" +
                "id=" + id +
                ", 用户名：'" + username + '\'' +
                ", 用户操作：'" + operation + '\'' +
                ", 请求方法：'" + method + '\'' +
                ", 请求参数：'" + params + '\'' +
                ", 执行时常：" + time +
                ", ip：'" + ip + '\'' +
                ", 创建时间：" + createDate +
                ", 更新时间：" + updateDate +
                '}';
    }
}
